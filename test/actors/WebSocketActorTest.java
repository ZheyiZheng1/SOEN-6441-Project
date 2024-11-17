package actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import org.junit.*;
import services.YTResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;
/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/16
 * This is the WebSocketActorTest class. This class test all features of the WebSocketActor class.
 */
public class WebSocketActorTest {
    private ActorSystem actorSystem;

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/16
     * This is the setup method. It makes sure the actor system is properly created.
     */
    @Before
    public void setup(){
        actorSystem = ActorSystem.create();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/16
     * This is the teardown method. It makes sure the actor system is properly closed.
     */
    @After
    public void teardown(){
        TestKit.shutdownActorSystem(actorSystem);
        actorSystem=null;
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/16
     * This is the testReceiveKeyWordAndReturn method. It mocks messages between actors and check if result from WebSocketActor match with expected value.
     */
    @Test
    public void testReceiveKeyWordAndReturn(){
        new TestKit(actorSystem){{
            final TestKit testProbe = new TestKit(actorSystem);
            final TestKit apiProbe = new TestKit(actorSystem);
            final TestKit readabilityProbe = new TestKit(actorSystem);
            final ActorRef webSocketActor = actorSystem.actorOf(WebSocketActor.props(testProbe.getRef()));
            webSocketActor.tell(new ProjectProtocol.UpdateApiAndReadabilityRef(apiProbe.getRef(), readabilityProbe.getRef()), getTestActor());
            // Send keyword to web socket actor
            webSocketActor.tell("java", testProbe.getRef());

            // Verify that the APIActor received the correct keyword
            ProjectProtocol.KeyWordSearch keyWordSearchMsg = apiProbe.expectMsgClass(ProjectProtocol.KeyWordSearch.class);
            assertEquals("java", keyWordSearchMsg.keyword);

            YTResponse yt1 = new YTResponse();
            YTResponse yt2 = new YTResponse();
            yt1.setTitle("test1");
            yt1.setVideoId("12345");
            yt1.setVideoLink("testLink1");
            yt1.setChannelId("123");
            yt1.setChannelTitle("test channel1");
            yt1.setChannelProfileLink("test profile link1");
            yt1.setDescription("This is the first description.");
            yt1.setThumbnailUrl("test thumbnail url 1");
            yt1.setFre(83.3);
            yt1.setFkgl(2.9);

            yt2.setTitle("test2");
            yt2.setVideoId("45678");
            yt2.setVideoLink("testLink2");
            yt2.setChannelId("456");
            yt2.setChannelTitle("test channel2");
            yt2.setChannelProfileLink("test profile link2");
            yt2.setDescription("This is the second description.");
            yt2.setThumbnailUrl("test thumbnail url 2");
            yt2.setFkgl(5.2);
            yt2.setFre(66.4);
            List<YTResponse> ytResponses = Arrays.asList(yt1, yt2);

            CompletableFuture<List<YTResponse>> future = CompletableFuture.completedFuture(ytResponses);
            webSocketActor.tell(future, apiProbe.getRef());

            // Verify that the ReadabilityActor received the ReadabilityCheck message
            ProjectProtocol.ReadabilityCheck readabilityCheckMsg = readabilityProbe.expectMsgClass(ProjectProtocol.ReadabilityCheck.class);
            assertNotNull(readabilityCheckMsg);

            // Simulate the ReadabilityActor returning a ReadabilityResponse
            List<Double> fre = new ArrayList<>();
            List<Double> fkgl = new ArrayList<>();
            fre.add(83.3);
            fre.add(66.4);
            fkgl.add(2.9);
            fkgl.add(5.2);

            ProjectProtocol.ReadabilityResponse readabilityResponse = new ProjectProtocol.ReadabilityResponse(fre, fkgl, 74.85, 4.03);
            webSocketActor.tell(readabilityResponse, readabilityProbe.getRef());

            // Verify the final response sent back to the WebSocket client
            String expectedResponse = "4.03\n74.85\n" +yt1.toHTMLString()+ "\n" + yt2.toHTMLString();
            String actualResponse = testProbe.expectMsgClass(String.class);
            assertEquals(expectedResponse, actualResponse);
        }};
    }
}
