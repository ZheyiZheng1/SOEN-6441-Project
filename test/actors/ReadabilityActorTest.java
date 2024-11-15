package actors;

import static org.junit.Assert.assertEquals;

import akka.actor.*;
import akka.testkit.TestActorRef;
import akka.testkit.javadsl.TestKit;
import actors.ProjectProtocol.*;
import services.YTResponse;
import actors.ReadabilityActor;
import actors.ProjectProtocol.ReadabilityCheck;
import actors.ProjectProtocol.ReadabilityResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ReadabilityActorTest {

    private ActorSystem system;

    @Before
    public void setUp() {
        system = ActorSystem.create();
    }

    @After
    public void tearDown() {
        TestKit.shutdownActorSystem(system);
    }

    @Test
    public void testReadabilityActor() {
        new TestKit(system){{
            // Create a mock list of YTResponse with descriptions
            YTResponse yt1 = new YTResponse();
            yt1.setTitle("test1");
            yt1.setVideoId("12345");
            yt1.setDescription("This is the first description.");

            YTResponse yt2 = new YTResponse();
            yt2.setTitle("test1");
            yt2.setVideoId("67890");
            yt2.setDescription("This is the second description.");
            List<YTResponse> ytResponses = Arrays.asList(yt1, yt2);

            // Wrap the list in a CompletableFuture
            CompletableFuture<List<YTResponse>> future = CompletableFuture.completedFuture(ytResponses);

            // Create the actor reference
            TestActorRef<ReadabilityActor> actorRef = TestActorRef.create(system, ReadabilityActor.getProps());

            // Send the ReadabilityCheck message to the actor
            actorRef.tell(new ReadabilityCheck(future), getTestActor());

            // Expect a ReadabilityResponse from the actor
            @SuppressWarnings("unchecked")
            ReadabilityResponse response = (ReadabilityResponse) expectMsgClass(ReadabilityResponse.class);
            // Assert the results (adjust expected values based on actual calculations)
            assertEquals("Expected FRE list size", 2, response.fre.size());
            assertEquals("Expected FKGL list size", 2, response.fkgl.size());
            assertEquals("Expected average FRE", 74.85, response.avgFRE, 0.1);
            assertEquals("Expected average FKGL", 4.03, response.avgFKGL, 0.1);
        }};

    }

}