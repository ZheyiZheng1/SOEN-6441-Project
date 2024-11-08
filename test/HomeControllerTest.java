import controllers.HomeController;
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
import org.junit.Test;

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

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/24
 * This is the test class for home controller.
 */
public class HomeControllerTest {

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
        System.out.println(content);

        // Check that the rendered correctly
        assertTrue(content.contains("Welcome to YT Lytics"));
        assertTrue(content.contains("<input type=\"submit\" value=\"submit\">"));
        assertTrue(content.contains("<input type=\"text\" id=\"keyword\" name=\"keyword\""));
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
        assertTrue(content.contains("Search term: java"));
    }

}
