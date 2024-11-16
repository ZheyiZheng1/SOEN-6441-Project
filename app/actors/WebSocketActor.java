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
    // keep searched keywords
    private List<String> searchHistory;
    // Keep search results
    private List<List<YTResponse>> searchResults;

    public WebSocketActor(ActorRef out, ActorRef apiActor) {
        this.out = out;
        this.apiActor = apiActor;
        this.searchHistory = new LinkedList<>();
        this.searchResults = new LinkedList<>();
    }

    static public Props props(ActorRef out, ActorRef apiActor) {
        return Props.create(WebSocketActor.class, () -> new WebSocketActor(out, apiActor));
    }

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
                        // Store the result in search results, only keep 10 most recent results
                        if (searchResults.size() >= 10) {
                            searchResults.remove(0);
                        }
                        searchResults.add((List<YTResponse>) results);
                        String response = ((List<YTResponse>) results).stream()
                                .map(result -> result.getTitle()+" - " + result.getVideoLink())
                                .collect(Collectors.joining("\n"));
                        System.out.println("Sending results: " + response);

                        // Send the result back to the WebSocket client
                        out.tell(response, getSelf());
                    }).exceptionally(ex -> {
                        System.out.println("Error processing information");
                        return null;
                    });
                })
                .build();
    }

    @Override
    public void postStop() throws Exception {
        // Cleanup resources when the actor is stopped
        super.postStop();
    }

}
