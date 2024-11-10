package services;

import Model.TextSegment;
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
import java.util.List;
import java.util.concurrent.CompletableFuture;



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
            return ok(tags.render(video)); // Pass video details to the view
        });
    }

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
        return ytRestDir.searchVideosAsynch(tag, null, "10").thenApply(videos -> {
            ArrayList<ArrayList<ArrayList<TextSegment>>> userList = new ArrayList<>();
            ArrayList<ArrayList<String>> userReadability = new ArrayList<>();

            for (YTResponse video : videos) {
                ArrayList<TextSegment> segments = new ArrayList<>();
                segments.add(new TextSegment("Title: ", video.getVideoLink()));
                segments.add(new TextSegment(video.getTitle(), null));
                segments.add(new TextSegment(", Channel: ", null));
                segments.add(new TextSegment(video.getChannelTitle(), video.getChannelProfileLink()));
                segments.add(new TextSegment(", Description: " + video.getDescription(), null));

                ArrayList<ArrayList<TextSegment>> videoResult = new ArrayList<>();
                videoResult.add(segments);
                userList.add(videoResult);

                userReadability.add(new ArrayList<>(List.of("N/A", "N/A"))); // Placeholder
            }

            Form<SearchForm> searchForm = formFactory.form(SearchForm.class);
            Messages messages = messagesApi.preferred(request);
            ArrayList<String> keywords = new ArrayList<>();
            keywords.add(tag);

            return ok(searchResults.render(keywords, userList, userReadability, searchForm, messages, request));
        }).exceptionally(ex -> {
            return internalServerError("An error occurred while searching for videos by tag.");
        });
    }




}
