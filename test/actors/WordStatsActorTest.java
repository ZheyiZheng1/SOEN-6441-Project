package actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.YTResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WordStatsActorTest {

    private ActorSystem actorSystem;

    @Before
    public void setup() {
        actorSystem = ActorSystem.create();
    }

    @After
    public void teardown() {
        TestKit.shutdownActorSystem(actorSystem);
        actorSystem = null;
    }

    @Test
    public void testWordStatsActor() {
        new TestKit(actorSystem) {{
            // Arrange
            final ActorRef wordStatsActor = actorSystem.actorOf(WordStatsActor.getProps());

            // Mock YTResponse descriptions
            YTResponse yt1 = new YTResponse();
            yt1.setDescription("apple banana apple orange");

            YTResponse yt2 = new YTResponse();
            yt2.setDescription("banana orange apple");

            List<YTResponse> descriptions = Arrays.asList(yt1, yt2);

            // Prepare WordStatsRequest
            ProjectProtocol.WordStatsRequest request = new ProjectProtocol.WordStatsRequest("12345", descriptions);

            // Act
            wordStatsActor.tell(request, getRef());

            // Assert
            WordStatsActor.WordStatsResults response = expectMsgClass(WordStatsActor.WordStatsResults.class);

            assertEquals("12345", response.videoId);

            // Verify wordStats
            JsonNode wordStats = response.wordStats;
            assertEquals(3, wordStats.get("apple").asLong());
            assertEquals(2, wordStats.get("banana").asLong());
            assertEquals(2, wordStats.get("orange").asLong());
        }};
    }
}