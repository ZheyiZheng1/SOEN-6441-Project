package actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import services.YTResponse;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/14
 * This is the WebSocketActor class. This class keeps websocket with user, receive keyword from user,
 * forward keyword to APIActor, keep all search results and return all search results to user.
 */
public class WebSocketActor extends AbstractActor {

    private final ActorRef out;
    private final ActorRef apiActor;
    private final ActorRef readabilityActor;
    // keep searched keywords
    private List<String> searchHistory;
    // Keep search results
    private List<List<YTResponse>> searchResults;


    public WebSocketActor(ActorRef out, ActorRef apiActor, ActorRef readabilityActor) {
        this.out = out;
        this.apiActor = apiActor;
        this.readabilityActor = readabilityActor;
        this.searchHistory = new LinkedList<>();
        this.searchResults = new LinkedList<>();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the getProps method. This method allows Props create APIActor.
     * @param out from Flow.
     * @return Props Proper return object in Akka
     */
    static public Props props(ActorRef out, ActorRef apiActor, ActorRef readabilityActor) {
        return Props.create(WebSocketActor.class, () -> new WebSocketActor(out, apiActor, readabilityActor));
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
                    if (searchHistory.size() >= 10) {
                        // Remove the oldest entry if size exceeds 10
                        searchHistory.remove(0);
                    }
                    // Store the keyword in search history
                    searchHistory.add(keyword);

                    // Forward the keyword to the APIActor for processing
                    apiActor.tell(new ProjectProtocol.KeyWordSearch(keyword, null, null), getSelf());
                })
                .match(CompletableFuture.class, future -> {
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
                    // Receive readability response from the ReadabilityActor
                    double avgFRE = message.avgFRE;
                    double avgFKGL = message.avgFKGL;
                    List<Double> fre = message.fre;
                    List<Double> fkgl = message.fkgl;
                    for (int i=0; i<searchResults.get(searchResults.size()-1).size(); i++){
                        searchResults.get(0).get(i).setFre(fre.get(i));
                        searchResults.get(0).get(i).setFkgl(fkgl.get(i));
                    }
                    // Send message back
                    String response = avgFKGL + "\n" + avgFRE + "\n";
                    response += searchResults.get(searchResults.size()-1).stream()
                            .map(result -> result.toHTMLString())
                            .collect(Collectors.joining("\n"));

                    System.out.println("Sending results: \n" + response);
                    // Send the result back to the WebSocket client
                    out.tell(response, getSelf());
                })
                .build();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the postStop method. This method cleanup resources when the actor is stopped.
     */
    @Override
    public void postStop() throws Exception {
        // Cleanup resources when the actor is stopped
        super.postStop();
    }

}
