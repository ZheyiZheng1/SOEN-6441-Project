import services.TagsService;
import org.junit.jupiter.api.Test;
import play.Application;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import services.YTRestDir;
import services.YTResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.route;
import static play.mvc.Http.Status.OK;
import static play.mvc.Http.Status.NOT_FOUND;
import static play.mvc.Http.Status.INTERNAL_SERVER_ERROR;


/**
 * @author: Pulkit Bansal - 40321488
 * Unit tests for the {@link TagsService} class.
 *
 * <p>This class tests the functionality of the {@link TagsService} methods, specifically:
 * <ul>
 *     <li>Displaying tags for a specific video (`showTags` method).</li>
 *     <li>Searching for videos by a specific tag (`searchByTag` method).</li>
 * </ul>
 *
 * <p>Mocking is used to simulate interactions with external dependencies like {@link YTRestDir}.
 */


public class TagsServiceTest {

    private final Application app = new GuiceApplicationBuilder().build();
    private final YTRestDir ytRestDir = mock(YTRestDir.class);
    private final FormFactory formFactory = app.injector().instanceOf(FormFactory.class);
    private final MessagesApi messagesApi = app.injector().instanceOf(MessagesApi.class);
    private final TagsService tagsController = new TagsService(ytRestDir, formFactory, messagesApi);

    /**
     * Tests the `showTags` method when the video is found.
     *
     * <p>This test ensures that when a video is found by its ID, the response has a status of 200 OK.
     * The video details are mocked and passed to the `ytRestDir` service for validation.
     * </p>
     *
     * @throws Exception if an error occurs during the asynchronous call.
     */

    @Test
    public void testShowTagsVideoFound() throws Exception {
        YTResponse mockResponse = new YTResponse();
        mockResponse.setVideoId("12345");
        mockResponse.setTitle("Test Video");
        mockResponse.setChannelTitle("Test Channel");
        mockResponse.setDescription("This is a test video.");

        when(ytRestDir.getVideoDetails("12345")).thenReturn(CompletableFuture.completedFuture(mockResponse));

        Http.RequestBuilder request = fakeRequest().method("GET").uri("/tags/12345");
        Result result = tagsController.showTags("12345").toCompletableFuture().get();

        assertEquals(OK, result.status());
        verify(ytRestDir, times(1)).getVideoDetails("12345");
    }

    /**
     * Tests the `showTags` method when the video is not found.
     *
     * <p>This test ensures that when a video with the given ID is not found, the response status is 404 NOT FOUND.
     * </p>
     *
     * @throws Exception if an error occurs during the asynchronous call.
     */

    @Test
    public void testShowTagsVideoNotFound() throws Exception {
        when(ytRestDir.getVideoDetails("unknownId")).thenReturn(CompletableFuture.completedFuture(null));

        Http.RequestBuilder request = fakeRequest().method("GET").uri("/tags/unknownId");
        Result result = tagsController.showTags("unknownId").toCompletableFuture().get();

        assertEquals(NOT_FOUND, result.status());
        verify(ytRestDir, times(1)).getVideoDetails("unknownId");
    }


    /**
     * Tests the `searchByTag` method for a successful search.
     *
     * <p>This test ensures that searching for videos by tag returns a status of 200 OK.
     * The `ytRestDir` is mocked to return a list of video responses that match the tag.
     * </p>
     *
     * @throws Exception if an error occurs during the asynchronous call.
     */

    @Test
    public void testSearchByTagSuccess() throws Exception {
        List<YTResponse> mockResponses = new ArrayList<>();
        YTResponse mockVideo = new YTResponse();
        mockVideo.setVideoId("12345");
        mockVideo.setTitle("Test Video");
        mockVideo.setChannelTitle("Test Channel");
        mockVideo.setDescription("This is a test video.");
        mockResponses.add(mockVideo);

        when(ytRestDir.searchVideosAsynch(anyString(), any(), anyString())).thenReturn(CompletableFuture.completedFuture(mockResponses));

        Http.RequestBuilder request = fakeRequest().method("GET").uri("/searchByTag/testTag");
        Result result = tagsController.searchByTag("testTag", request.build()).toCompletableFuture().get();

        assertEquals(OK, result.status());
        verify(ytRestDir, times(1)).searchVideosAsynch("testTag", null, "10");
    }


    /**
     * Tests the `searchByTag` method when an error occurs during the search.
     *
     * <p>This test ensures that when an error occurs during the video search by tag,
     * the response status is 500 INTERNAL SERVER ERROR.
     * </p>
     *
     * @throws Exception if an error occurs during the asynchronous call.
     */
    @Test
    public void testSearchByTagFailure() throws Exception {
        when(ytRestDir.searchVideosAsynch(anyString(), any(), anyString())).thenReturn(CompletableFuture.failedFuture(new Exception("Test exception")));

        Http.RequestBuilder request = fakeRequest().method("GET").uri("/searchByTag/failTag");
        Result result = tagsController.searchByTag("failTag", request.build()).toCompletableFuture().get();

        assertEquals(INTERNAL_SERVER_ERROR, result.status());
        verify(ytRestDir, times(1)).searchVideosAsynch("failTag", null, "10");
    }
}
