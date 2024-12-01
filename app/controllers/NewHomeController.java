package controllers;

import actors.ReadabilityActor;
import actors.WordStatsActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import javax.inject.Inject;
import akka.actor.Props;
import play.libs.F.Either;
import play.libs.streams.ActorFlow;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import actors.APIActor;
import actors.WebSocketActor;
import services.YTResponse;
import services.YTRestDir;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/14
 * This is the NewHomeController class. This is the only controller we use in project 2.
 */
public class NewHomeController extends Controller {

    private final ActorSystem actorSystem;
    private final Materializer materializer;

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the constructor method.
     */
    @Inject
    public NewHomeController(ActorSystem actorSystem, Materializer materializer) {
        this.actorSystem = actorSystem;
        this.materializer = materializer;
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the index method. This method make sure user can reach the index page with on data correctly.
     * @return  Result standard return value in Play framework.
     */
    public Result index(){
        // The view with only a search box
        return ok(views.html.index.render());
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the ws method. This method make sure program act correctly when user side request to open a websocket.
     * When user request to open a websocket with a search keyword, create an WebSocketActor to communicate with user.
     * APIActor in charge of making API call to YouTube.
     * @return WebSocket standard return for websocket.
     */
    public WebSocket ws() {
        // Create a web socket and return
        return WebSocket.Text.acceptOrResult(request -> {
            // Create actor
            return CompletableFuture.completedFuture(Either.Right(
                    ActorFlow.actorRef(out -> WebSocketActor.props(out), actorSystem, materializer)
            ));
        });
    }

    public Result GetWordStats(String query){
        JsonNode wordStat = WordStatsActor.wordStatsMap.get(query);
        return ok(views.html.wordstats.render(wordStat, query));
    }

    /**
     * @author: Pulkit Bansal - 40321488
     * Created: 2024/11/17
     * Handles the redirection to the tag details page.
     * Fetches video details based on the given video ID.
     *
     * @param videoId The selected video ID.
     * @return A rendered page with video details.
     */
    public Result tagDetails(String videoId) {
        try {
            // Use YTRestDir to fetch video details for the given video ID
            YTRestDir ytRestDir = new YTRestDir();
            YTResponse videoDetails = ytRestDir.getVideoDetails(videoId).get();

            if (videoDetails == null) {
                // Handle case when no video is found
                return notFound("Video not found.");
            }

            // Render the tag details view with fetched video details
            return ok(views.html.tagDetails.render(videoDetails));
        } catch (Exception e) {
            // Handle any exceptions during the API call
            e.printStackTrace();
            return internalServerError("An error occurred while fetching video details.");
        }
    }

    public Result tagSearch(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return badRequest("Keyword is required.");
        }

        try {
            // Fetch search results based on the tag keyword
            YTRestDir ytRestDir = new YTRestDir();
            List<YTResponse> searchResults = ytRestDir.searchVideos(keyword).get();

            if (searchResults == null || searchResults.isEmpty()) {
                return notFound("No results found for the keyword: " + keyword);
            }

            // Render the tag search results page
            return ok(views.html.tagSearchResults.render(keyword, searchResults));
        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError("An error occurred while fetching search results.");
        }
    }
}
