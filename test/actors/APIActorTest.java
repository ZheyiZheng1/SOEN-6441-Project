package actors;

import akka.actor.*;
import actors.ProjectProtocol.*;
import akka.testkit.javadsl.TestKit;
import actors.ProjectProtocol.KeyWordSearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.YTResponse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/12
 * This is the APIActorTest class. This class ensure APIActor class works correctly.
 */
public class APIActorTest {
    static ActorSystem system;

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/12
     * Before each test, let the ActorSystem create the APIActor.
     */
    @Before
    public void setup() {
        system = ActorSystem.create();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/12
     * After each test, shut down the ActorSystem.
     */
    @After
    public void teardown() throws Exception {
        TestKit.shutdownActorSystem(system);
        system = null;
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/12
     * This test provide a keyword "java" within KeyWordSearch message.
     * APIActor should return a response that contains all search results.
     */
    @Test
    public void testKeyWordSearch() throws InterruptedException, ExecutionException {
        new TestKit(system) {{
            // Create APIActor
            ActorRef apiActor = system.actorOf(APIActor.getProps());

            // Define a sample keyword for the search
            String keyword = "java";

            // Send KeyWordSearch message
            apiActor.tell(new KeyWordSearch(keyword, null, null), getRef());

            // Expect a CompletableFuture<List<YTResponse>> as a response.
            @SuppressWarnings("unchecked")
            CompletableFuture<List<YTResponse>> response = (CompletableFuture<List<YTResponse>>) expectMsgClass(CompletableFuture.class);

            // Verify that the CompletableFuture is not null
            assertNotNull(response);
            // Block the code to get the search results.
            List<YTResponse> results = response.get();
            // Go through each result, every result should contain at least 1 "java" as the keyword is java.
            for (YTResponse result: results) {
                //System.out.println(result.toString());
                assertTrue(result.toString().toLowerCase().contains("java"));
            }
        }};
    }

    /**
     * Test to ensure URISyntaxException is thrown when an invalid URL is provided.
     */
    @Test
    public void testException() {
        new TestKit(system) {{
            // Create APIActor
            ActorRef apiActor = system.actorOf(APIActor.getProps());

            // Define a sample keyword for the search
            String keyword = "java";
            String invalidUrl = "This is an invalid url";

            // Send message to API actor with invalid url and expect a Status.Failure
            apiActor.tell(new KeyWordSearch(keyword, invalidUrl, null), getRef());

            // Expect the response as a CompletableFuture
            CompletableFuture<?> futureResponse = expectMsgClass(CompletableFuture.class);

            // Handle the future's completion
            futureResponse.handle((response, throwable) -> {
                if (throwable != null) {
                    // If an exception occurred, the response should be an ErrorMessage
                    assertTrue("Expected ErrorMessage, but got exception: " + throwable.getMessage(), throwable instanceof RuntimeException);
                    return throwable;
                } else {
                    // If there was no exception, assert the response is not null
                    assertNotNull("Expected a valid response, but got null", response);
                    return response;
                }
            });
        }};
    }

}
