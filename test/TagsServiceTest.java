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

public class TagsServiceTest {

    private final Application app = new GuiceApplicationBuilder().build();
    private final YTRestDir ytRestDir = mock(YTRestDir.class);
    private final FormFactory formFactory = app.injector().instanceOf(FormFactory.class);
    private final MessagesApi messagesApi = app.injector().instanceOf(MessagesApi.class);
    private final TagsService tagsController = new TagsService(ytRestDir, formFactory, messagesApi);

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

    @Test
    public void testShowTagsVideoNotFound() throws Exception {
        when(ytRestDir.getVideoDetails("unknownId")).thenReturn(CompletableFuture.completedFuture(null));

        Http.RequestBuilder request = fakeRequest().method("GET").uri("/tags/unknownId");
        Result result = tagsController.showTags("unknownId").toCompletableFuture().get();

        assertEquals(NOT_FOUND, result.status());
        verify(ytRestDir, times(1)).getVideoDetails("unknownId");
    }

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

    @Test
    public void testSearchByTagFailure() throws Exception {
        when(ytRestDir.searchVideosAsynch(anyString(), any(), anyString())).thenReturn(CompletableFuture.failedFuture(new Exception("Test exception")));

        Http.RequestBuilder request = fakeRequest().method("GET").uri("/searchByTag/failTag");
        Result result = tagsController.searchByTag("failTag", request.build()).toCompletableFuture().get();

        assertEquals(INTERNAL_SERVER_ERROR, result.status());
        verify(ytRestDir, times(1)).searchVideosAsynch("failTag", null, "10");
    }
}
