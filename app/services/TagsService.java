package services;

import Model.TextSegment;
import Model.BeforeView;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.i18n.Messages;
import play.mvc.Http.Request;
import play.mvc.*;
import Model.SearchForm;
import views.html.Home.searchResults;
import views.html.Home.tags;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CompletionException;



/**
 * Service for handling video tags and related operations.
 *
 * <p>This service provides methods to display tags of a specific video,
 * as well as search for videos by a specified tag. It uses the {@link YTRestDir}
 * service for interacting with YouTube to get video details and search videos asynchronously.</p>
 *
 * <p>The service methods are designed to be used in a reactive manner, leveraging
 * {@link CompletableFuture} to handle asynchronous responses from the YouTube Data API.</p>
 *
 * <p>Author: Pulkit Bansal - 40321488</p>
 */

public class TagsService extends Controller {

    private final YTRestDir ytRestDir;
    private final FormFactory formFactory;
    private final MessagesApi messagesApi;
    private final BeforeView beforeView;


    /**
     * Constructs a new TagsService with the specified dependencies.
     *
     * @param ytRestDir   The YouTube REST Directory service used for interacting with the YouTube Data API.
     * @param formFactory The form factory used for handling form data.
     * @param messagesApi The messages API used for handling internationalization messages.
     */

    @Inject
    public TagsService(YTRestDir ytRestDir, FormFactory formFactory, MessagesApi messagesApi) {
        this.ytRestDir = ytRestDir;
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
        this.beforeView = new BeforeView();
    }

    /**
     * Displays the tags page for a specific video.
     *
     * <p>This method fetches the video details, including its tags, by interacting with the {@link YTRestDir}
     * service. If the video details are found, it renders the tags view. Otherwise, it returns a 404 error.</p>
     *
     * @param videoId The ID of the video to fetch details and tags for.
     * @return A {@link CompletableFuture} of {@link Result} that renders the tags page view.
     *         Returns a "not found" response if the video could not be located.
     */
    public CompletableFuture<Result> showTags(String videoId) {
        return ytRestDir.getVideoDetails(videoId).thenApply(video -> {
            if (video == null) {
                return notFound("Video not found.");
            }
            // Pass the YTResponse object directly to the view
            return ok(views.html.Home.tags.render(video)); // This matches the expected argument type in the view
        }).exceptionally(e -> {
            e.printStackTrace();
            return internalServerError("Error occurred while fetching video details.");
        });
    }


//
//    public CompletableFuture<Result> showVideoDetails(String videoId) {
//        return ytRestDir.getVideoDetails(videoId)
//                .thenApply(video -> {
//                    if (video == null) {
//                        return notFound("Video not found.");
//                    }
//
//                    String videoTitle = (String) video.getTitle();
//                    String videoDescription = (String) video.getDescription();
//                    List<String> tags = (List<String>) video.getTags();
//
//                    return ok(views.html.Home.tags.render(videoTitle, videoDescription, tags));
//                })
//                .exceptionally(e -> {
//                    e.printStackTrace();
//                    return internalServerError("Error occurred while fetching video details.");
//                });
//    }

    /**
     * Searches for videos by a specified tag and renders the search results page.
     *
     * <p>This method searches for videos that match the given tag by interacting with the
     * {@link YTRestDir} service asynchronously. Once the search results are retrieved,
     * it prepares the video details to be displayed in the search results view.</p>
     *
     * <p>If the search fails due to an error, a 500 Internal Server Error response is returned.</p>
     *
     * @param tag     The tag used to search for videos.
     * @param request The HTTP request object.
     * @return A {@link CompletableFuture} of {@link Result} that renders the search results view
     *         with videos containing the specified tag.
     */
    public CompletableFuture<Result> searchByTag(String tag, Request request) {
        try{
            // Create the form and get the search query from the tag
            Form<SearchForm> searchForm = formFactory.form(SearchForm.class);

            // Use YTRestDir to fetch the search results for the given tag
            CompletableFuture<List<YTResponse>> result = ytRestDir.searchVideosAsynch(tag, null, "50");

            // Process the result similar to the search method
            CompletableFuture<List<YTResponse>> result2 = result.thenApply(list -> list.stream().limit(10).collect(Collectors.toList()));

            // Call BeforeView to get and return the information to view
            return beforeView.process(request, tag, result2, formFactory, messagesApi);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(internalServerError("An error occurred while processing the tag search."));
        }

    }





}
