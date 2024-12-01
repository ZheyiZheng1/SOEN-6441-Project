package actors;

import Model.FetchTags;
import Model.TextSegment;
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
import java.util.stream.Collectors;

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
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/25
     * This test provide a keyword "java" within KeyWordSearch message.
     * APIActor should return a response that contains all search results.
     */
    @Test
    public void testUpdateDataRequest() throws InterruptedException, ExecutionException {
        new TestKit(system) {{
            // Create APIActor
            ActorRef apiActor = system.actorOf(APIActor.getProps());

            // Define a sample keyword for the search
            String keyword = "java";

            // Send UpdateDataRequest message
            apiActor.tell(new UpdateDataRequest(keyword, null, null), getRef());

            // Expect a CompletableFuture<List<YTResponse>> as a response.
            @SuppressWarnings("unchecked")
            UpdateDataResponse rawResponse = (UpdateDataResponse) expectMsgClass(UpdateDataResponse.class);
            CompletableFuture<List<YTResponse>> response = rawResponse.updatedData;
            String returnedKeyword = rawResponse.keyword;
            // Verify that the keyword is correct
            assertEquals(keyword, returnedKeyword);
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
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/12
     * Test to see if the APIActor throws exception correctly when the url is invalid.
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


    /**
     * @author: Pulkit Bansal - 40321488
     * Created: 2024/11/25
     * This test provides a keyword and verifies the asynchronous search behavior of the APIActor.
     */
    @Test
    public void testSearchVideosAsynch() throws InterruptedException, ExecutionException {
        new TestKit(system) {{
            // Create APIActor
            ActorRef apiActor = system.actorOf(APIActor.getProps());

            // Define a sample keyword for the search
            String keyword = "java";

            // Send KeyWordSearch message to the APIActor
            apiActor.tell(new KeyWordSearch(keyword, null, null), getRef());

            // Expect a CompletableFuture<List<YTResponse>> as a response.
            @SuppressWarnings("unchecked")
            CompletableFuture<List<YTResponse>> response = (CompletableFuture<List<YTResponse>>) expectMsgClass(CompletableFuture.class);

            // Verify that the CompletableFuture is not null
            assertNotNull("Response should not be null", response);

            // Block to retrieve the results
            List<YTResponse> results = response.get();

            // Verify that results are not empty
            assertNotNull("Results list should not be null", results);
            assertFalse("Results list should not be empty", results.isEmpty());

            // Verify that all results contain the keyword
            for (YTResponse result : results) {
                assertTrue("Each result should contain the keyword", result.toString().toLowerCase().contains("java"));
            }
        }};
    }


}
