package actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import actors.ProjectProtocol.KeyWordSearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.YTResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

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
    public void teardown() {
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
            apiActor.tell(new KeyWordSearch(keyword), getRef());

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

}
