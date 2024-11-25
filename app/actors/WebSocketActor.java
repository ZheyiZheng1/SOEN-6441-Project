package actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.Cancellable;
import akka.japi.pf.DeciderBuilder;

import scala.concurrent.duration.Duration;
import services.YTResponse;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/14
 * This is the WebSocketActor class. This class keeps websocket with user, receive keyword from user,
 * forward keyword to APIActor, keep all search results and return all search results to user.
 * WebSocketActor is also the supervisor to all other actors. Home controller also only knows about WebSocketActor.
 */
public class WebSocketActor extends AbstractActor {

    private final ActorRef out;
    private ActorRef apiActor;
    private ActorRef readabilityActor;
    // keep searched keywords
    private List<String> searchHistory;
    // Keep search results
    private List<List<YTResponse>> searchResults;
    private List<Double> avgFKGL;
    private List<Double> avgFRE;
    // Scheduler for periodic updates
    private Cancellable refreshScheduler;
    // Default refresh interval
    private int refreshInterval = 10;

    private final SupervisorStrategy strategy = new OneForOneStrategy(
            -1,
            java.time.Duration.ofMinutes(3),
            DeciderBuilder.match(TimeoutException.class,
                    // Timeout exception, should be able to resolve in the next message, so resume.
                    e -> SupervisorStrategy.resume()
            ).match(RuntimeException.class,
                    // Runtime exception, probably not be able to get resolve by itself, restart it.
                    e -> SupervisorStrategy.restart()
            ).matchAny(
                    // Any other issue, escalate it to actor system.
                    e -> SupervisorStrategy.escalate()
            ).build()
    );

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * Define the supervise strategy.
     */
    @Override
    public SupervisorStrategy supervisorStrategy(){
        return strategy;
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the constructor method.
     */
    @Inject
    public WebSocketActor(ActorRef out) {
        this.out = out;
        this.apiActor = getContext().actorOf(APIActor.getProps());
        this.readabilityActor = getContext().actorOf(ReadabilityActor.getProps());
        this.searchHistory = new LinkedList<>();
        this.searchResults = new LinkedList<>();
        this.avgFKGL = new LinkedList<>();
        this.avgFRE = new LinkedList<>();
        // Start the scheduler for keep refresh
        startScheduler();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the getProps method. This method allows Props create APIActor.
     * @param out from Flow.
     * @return Props Proper return object in Akka
     */
    static public Props props(ActorRef out) {
        return Props.create(WebSocketActor.class, () -> new WebSocketActor(out));
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the createReceive method. This method distinguish messages.
     * If the message is a string class, then it's a request message from user. Add the keyword to list and send keyWordSearch message to APIActor.
     * If the message is a CompletableFuture, then this is a response from APIActor. Read the information out and return new result to user.
     * @return Receive proper return object in Akka
     */
    @SuppressWarnings("unchecked")
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, keyword -> {
                    System.out.println("Received keyword: " + keyword);
                    // Check if the keyword is already inside the searchHistory
                    if (searchHistory.contains(keyword)){
                        // The keyword is in the searchHistory, just change the order of all information.
                        // Get index of this keyword
                        int index = searchHistory.indexOf(keyword);
                        // Retrieve all information from list
                        double targetAvgFre = avgFRE.get(index);
                        double targetAvgFkgl = avgFKGL.get(index);
                        List<YTResponse> targetResult = searchResults.get(index);
                        // Delete the original copy
                        searchHistory.remove(index);
                        avgFRE.remove(index);
                        avgFKGL.remove(index);
                        searchResults.remove(index);
                        // Add the result back at the last place of all lists.
                        searchHistory.add(keyword);
                        avgFRE.add(targetAvgFre);
                        avgFKGL.add(targetAvgFkgl);
                        searchResults.add(targetResult);
                    }else {
                        // The keyword is not in the searchHistory, fetch information from the YouTube
                        if (searchHistory.size() >= 10) {
                            // Remove the oldest entry if size exceeds 10
                            searchHistory.remove(0);
                        }
                        // Store the keyword in search history
                        searchHistory.add(keyword);
                        // Forward the keyword to the APIActor for processing
                        apiActor.tell(new ProjectProtocol.KeyWordSearch(keyword, null, null), getSelf());
                    }
                })
                .match(CompletableFuture.class, future -> {
                    System.out.println("Received CompletableFuture");
                    // Wait for the APIActor to return the search results
                    future.thenAccept(results -> {
                        // Send a message to the ReadabilityActor
                        readabilityActor.tell(new ProjectProtocol.ReadabilityCheck(future), getSelf());
                        // Store the result in search results, only keep 10 most recent results
                        if (searchResults.size() >= 10) {
                            searchResults.remove(0);
                        }
                        searchResults.add((List<YTResponse>) results);
                    });
                })
                .match(ProjectProtocol.ReadabilityResponse.class, message -> {
                    System.out.println("Received ReadabilityResponse");
                    // Receive readability response from the ReadabilityActor
                    double avgFRE = message.avgFRE;
                    double avgFKGL = message.avgFKGL;
                    List<Double> fre = message.fre;
                    List<Double> fkgl = message.fkgl;
                    for (int i=0; i<searchResults.get(searchResults.size()-1).size(); i++){
                        searchResults.get(0).get(i).setFre(fre.get(i));
                        searchResults.get(0).get(i).setFkgl(fkgl.get(i));
                    }

                    // Store the result in search results, only keep 10 most recent results
                    if (this.avgFKGL.size() >= 10) {
                        this.avgFKGL.remove(0);
                    }
                    if (this.avgFRE.size() >= 10) {
                        this.avgFRE.remove(0);
                    }
                    this.avgFKGL.add(avgFKGL);
                    this.avgFRE.add(avgFRE);
                })
                .match(ProjectProtocol.UpdateApiAndReadabilityRef.class, message ->{
                    // This should not be used, it is created for test purpose.
                    this.apiActor=message.apiActor;
                    this.readabilityActor=message.readabilityActor;
                })
                .match(RefreshResults.class, message -> {
                    System.out.println("Refreshing");
                    // Send all data back to user
                    // Create a JSON response
                    ObjectMapper mapper = new ObjectMapper();
                    ObjectNode root = mapper.createObjectNode();

                    // Add keywords as JSON array
                    ArrayNode searchHistoryArray = mapper.createArrayNode();
                    searchHistory.stream()
                            .sorted((a, b) -> Integer.compare(searchHistory.indexOf(b), searchHistory.indexOf(a)))
                            .forEach(searchHistoryArray::add);
                    root.set("searchHistory", searchHistoryArray);
                    // Add avgFKGL and avgFRE as JSON arrays
                    ArrayNode avgFKGLArray = mapper.createArrayNode();
                    avgFKGL.stream()
                            .sorted((a, b) -> Double.compare(avgFKGL.indexOf(b), avgFKGL.indexOf(a)))
                            .forEach(avgFKGLArray::add);
                    root.set("avgFKGL", avgFKGLArray);

                    ArrayNode avgFREArray = mapper.createArrayNode();
                    avgFRE.stream()
                            .sorted((a, b) -> Double.compare(avgFRE.indexOf(b), avgFRE.indexOf(a)))
                            .forEach(avgFREArray::add);
                    root.set("avgFRE", avgFREArray);

                    // Add searchResults as an array of arrays
                    ArrayNode searchResultsArray = mapper.createArrayNode();
                    searchResults.stream()
                            .sorted((a, b) -> Integer.compare(searchResults.indexOf(b), searchResults.indexOf(a)))
                            .forEach(resultList -> {
                                ArrayNode resultArray = mapper.createArrayNode();
                                resultList.forEach(result -> {
                                    ObjectNode resultNode = mapper.createObjectNode();
                                    resultNode.put("title", result.getTitle());
                                    resultNode.put("videoID", result.getVideoId());
                                    resultNode.put("videoLink", result.getVideoLink());
                                    resultNode.put("channelTitle", result.getChannelTitle());
                                    resultNode.put("channelID", result.getChannelId());
                                    resultNode.put("channelProfileLink", result.getChannelProfileLink());
                                    resultNode.put("description", result.getDescription());
                                    resultNode.put("thumbnailUrl", result.getThumbnailUrl());
                                    resultNode.put("fkgl", result.getFkgl());
                                    resultNode.put("fre", result.getFre());
                                    resultArray.add(resultNode);
                                });
                                searchResultsArray.add(resultArray);
                            });

                    root.set("searchResults", searchResultsArray);

                    // Convert the response object to a JSON string
                    String jsonResponse = mapper.writeValueAsString(root);

                    out.tell(jsonResponse, getSelf());
                })
                .build();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the postStop method. This method cleanup scheduler.
     */
    @Override
    public void postStop() throws Exception {
        if (refreshScheduler != null && !refreshScheduler.isCancelled()) {
            // Cleanup the scheduler
            refreshScheduler.cancel();
        }
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/24
     * This is the startScheduler class. This class setup a scheduler which send RefreshResults message to WebSocketActor every refreshInterval seconds.
     */
    private void startScheduler() {
        refreshScheduler = getContext().getSystem().scheduler().scheduleWithFixedDelay(
                Duration.create(0, SECONDS),
                Duration.create(refreshInterval, SECONDS),
                getSelf(), // Send message to WebSocketActor itself
                new RefreshResults(), // Message type is RefreshResults
                getContext().getDispatcher(), // Use the actor's dispatcher
                null // No sender
        );
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/24
     * This is the RefreshResults class. This class has nothing, only used as a message to let scheduler send data to view periodically.
     */
    private static class RefreshResults {
    }
}
