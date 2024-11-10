import controllers.HomeController;
import services.TagsService;
import Model.SearchForm;
import play.Application;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.Messages;
import play.i18n.MessagesApi;
import play.i18n.MessagesImpl;
import play.i18n.Lang;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import views.html.Home.display;
import views.html.Home.videoStatistics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static play.mvc.Http.Status.*;


import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;
import com.google.common.collect.ImmutableMap;
import static org.mockito.Mockito.*;
import static play.test.Helpers.contentAsString;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/24
 * This is the test class for home controller.
 */
public class HomeControllerTest {

    @Mock
    private TagsService tagsService;

    private HomeController homeController;

    @Before
    public void setUp() {
        // Initialize Mockito annotations to use @Mock
        MockitoAnnotations.openMocks(this);

        // Initialize the application context and inject mocks
        Application app = new GuiceApplicationBuilder().build();
        homeController = new HomeController(
                app.injector().instanceOf(FormFactory.class),
                app.injector().instanceOf(MessagesApi.class),
                tagsService
        );
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     * Test if the display view gets generated correctly with the display method in HomeController.
     */
    @Test
    public void testDisplay() {
        // Initialize the application context
        Application app = new GuiceApplicationBuilder().build();
        HomeController homeController = app.injector().instanceOf(HomeController.class);

        // Create a fake request
        Http.RequestBuilder request = fakeRequest(GET, "/");

        // Call the display method
        Result result = homeController.display(request.build());

        // Check the content type and output
        assertEquals("text/html", result.contentType().orElse(""));
        String content = contentAsString(result);
        //System.out.println(content);

        // Check that the rendered correctly
        assertTrue(content.contains("Welcome to YT Lytics"));
        assertTrue(content.contains("submit"));
        assertTrue(content.contains("keyword"));
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     * Test if the searchResult view gets generated correctly with the display method in HomeController.
     */
    @Test
    public void testSearch() throws ExecutionException, InterruptedException {
        // Initialize the application context
        Application app = new GuiceApplicationBuilder().build();
        HomeController homeController = app.injector().instanceOf(HomeController.class);

        // Create a fake request with search form data
        Http.RequestBuilder request = fakeRequest()
                .method("POST")
                .uri("/search")
                .bodyForm(ImmutableMap.of("keyword", "java"));

        // Call the search method and get the CompletableFuture result
        CompletableFuture<Result> futureResult = homeController.search(request.build());
        // Get the result directly
        Result result = futureResult.get();

        // Check the content type and output
        assertEquals("text/html", result.contentType().orElse(""));
        String content = contentAsString(result);
        System.out.println(content);

        // Check that the rendered content contains java
        assertTrue(content.contains("Learn Java in 14 Minutes"));
    }


    /**
     * Test the `searchByTag` method to ensure it returns correct search results.
     *
     * <p>This test verifies that the `searchByTag` method correctly calls the `TagsService`
     * and returns a status of 200 OK when a valid tag is provided.</p>
     *
     * @throws ExecutionException   if there is an error during the asynchronous process.
     * @throws InterruptedException if the current thread is interrupted while waiting.
     */
//    @Test
//    public void testSearchByTag() throws ExecutionException, InterruptedException {
//        // Mock the expected response from TagsService
//        CompletableFuture<Result> mockResult = CompletableFuture.completedFuture(ok("Mocked tag search response"));
//        when(tagsService.searchByTag(anyString(), any(Http.Request.class))).thenReturn(mockResult);
//
//        // Create a fake request to search by tag
//        Http.RequestBuilder request = fakeRequest()
//                .method("GET")
//                .uri("/searchByTag/testTag");
//
//        // Call the searchByTag method
//        CompletableFuture<Result> futureResult = homeController.searchByTag("testTag", request.build());
//        Result result = futureResult.get();
//
//        // Debugging: Print the result status
//        System.out.println("Result Status (searchByTag): " + result.status());
//
//        // Check that the response status is OK
//        assertTrue(result.status() == play.mvc.Http.Status.OK);
//
//        // Check that the content matches the mock response
//        String content = contentAsString(result);
//        assertTrue(content.contains("Mocked tag search response"));
//    }
//
//    /**
//     * Test the `showTags` method to ensure it returns correct tags for a video.
//     *
//     * <p>This test verifies that the `showTags` method correctly calls the `TagsService`
//     * and returns a status of 200 OK when a valid video ID is provided.</p>
//     *
//     * @throws ExecutionException   if there is an error during the asynchronous process.
//     * @throws InterruptedException if the current thread is interrupted while waiting.
//     */
//    @Test
//    public void testShowTags() throws ExecutionException, InterruptedException {
//        // Mock the expected response from TagsService
//        CompletableFuture<Result> mockResult = CompletableFuture.completedFuture(ok("Mocked tags response"));
//        when(tagsService.showTags(anyString())).thenReturn(mockResult);
//
//        // Create a fake request to show tags for a video
//        Http.RequestBuilder request = fakeRequest()
//                .method("GET")
//                .uri("/video/tags/12345");
//
//        // Call the showTags method
//        CompletableFuture<Result> futureResult = homeController.showTags("12345");
//        Result result = futureResult.get();
//
//        // Debugging: Print the result status
//        System.out.println("Result Status (showTags): " + result.status());
//
//        // Check that the response status is OK
//        assertTrue(result.status() == play.mvc.Http.Status.OK);
//
//        // Check that the content matches the mock response
//        String content = contentAsString(result);
//        assertTrue(content.contains("Mocked tags response"));
//    }
}
