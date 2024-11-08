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
 * @author: Pulkit Bansal - 40321488
 * Displays the tags page for a specific video.
 */

public class TagsService extends Controller {

    private final YTRestDir ytRestDir;
    private final FormFactory formFactory;
    private final MessagesApi messagesApi;

    @Inject
    public TagsService(YTRestDir ytRestDir, FormFactory formFactory, MessagesApi messagesApi) {
        this.ytRestDir = ytRestDir;
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
    }

    /**
     * Displays the tags page for a specific video.
     * @param videoId ID of the video to fetch details and tags
     * @return Rendered tags page view
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
     * Searches for videos by a specified tag and renders the searchResults page.
     * @param tag The tag to search for videos.
     * @param request The HTTP request object.
     * @return CompletableFuture<Result> that renders the search results with videos containing the specified tag.
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
