package actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import services.YTResponse;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/16
 * This is the ProjectProtocolTest class. This class test all messages inside ProjectProtocol class.
 */
public class ProjectProtocolTest {
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
     * This is the testKeyWordSearch method. Test set and retrieve value from it.
     */
    @Test
    public void testKeyWordSearch() {
        ProjectProtocol test = new ProjectProtocol();
        ProjectProtocol.KeyWordSearch keywordSearch = new ProjectProtocol.KeyWordSearch("java", "http://example.com", "10");

        assertEquals("java", keywordSearch.keyword);
        assertEquals("http://example.com", keywordSearch.url);
        assertEquals("10", keywordSearch.maxResult);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/16
     * This is the testReadabilityCheck method. Test set and retrieve value from it.
     */
    @Test
    public void testReadabilityCheck() {
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

        yt2.setTitle("test2");
        yt2.setVideoId("45678");
        yt2.setVideoLink("testLink2");
        yt2.setChannelId("456");
        yt2.setChannelTitle("test channel2");
        yt2.setChannelProfileLink("test profile link2");
        yt2.setDescription("This is the second description.");
        yt2.setThumbnailUrl("test thumbnail url 2");
        List<YTResponse> responses = Arrays.asList(yt1, yt2);
        CompletableFuture<List<YTResponse>> future = CompletableFuture.completedFuture(responses);
        ProjectProtocol.ReadabilityCheck readabilityCheck = new ProjectProtocol.ReadabilityCheck(future);

        assertEquals(future, readabilityCheck.result);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/16
     * This is the testReadabilityResponse method. Test set and retrieve value from it.
     */
    @Test
    public void testReadabilityResponse() {
        List<Double> freScores = Arrays.asList(60.0, 70.0);
        List<Double> fkglScores = Arrays.asList(6.0, 7.0);
        ProjectProtocol.ReadabilityResponse readabilityResponse = new ProjectProtocol.ReadabilityResponse(freScores, fkglScores, 65.0, 6.5);

        assertEquals(freScores, readabilityResponse.fre);
        assertEquals(fkglScores, readabilityResponse.fkgl);
        assertEquals(Double.valueOf(65.0), readabilityResponse.avgFRE);
        assertEquals(Double.valueOf(6.5), readabilityResponse.avgFKGL);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/16
     * This is the testErrorMessage method. Test set and retrieve value from it.
     */
    @Test
    public void testErrorMessage() {
        ProjectProtocol.ErrorMessage errorMessage = new ProjectProtocol.ErrorMessage("This is an error message");

        assertEquals("This is an error message", errorMessage.message);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/16
     * This is the testUpdateApiAndReadabilityRef method. Test set and retrieve value from it.
     */
    @Test
    public void testUpdateApiAndReadabilityRef() {
        new TestKit(actorSystem){{
            final TestKit apiProbe = new TestKit(actorSystem);
            final TestKit readabilityProbe = new TestKit(actorSystem);
            ProjectProtocol.UpdateApiAndReadabilityRef updateApiAndReadabilityRef = new ProjectProtocol.UpdateApiAndReadabilityRef(apiProbe.getRef(), readabilityProbe.getRef());

            assertEquals(apiProbe.getRef(), updateApiAndReadabilityRef.apiActor);
            assertEquals(readabilityProbe.getRef(), updateApiAndReadabilityRef.readabilityActor);
        }};
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/25
     * This is the testReadabilityUpdate method. Test set and retrieve value from it.
     */
    @Test
    public void testReadabilityUpdate() {
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

        yt2.setTitle("test2");
        yt2.setVideoId("45678");
        yt2.setVideoLink("testLink2");
        yt2.setChannelId("456");
        yt2.setChannelTitle("test channel2");
        yt2.setChannelProfileLink("test profile link2");
        yt2.setDescription("This is the second description.");
        yt2.setThumbnailUrl("test thumbnail url 2");
        List<YTResponse> responses = Arrays.asList(yt1, yt2);
        CompletableFuture<List<YTResponse>> future = CompletableFuture.completedFuture(responses);
        ProjectProtocol.ReadabilityUpdate readabilityUpdate = new ProjectProtocol.ReadabilityUpdate(future, "test keyword");

        assertEquals(future, readabilityUpdate.result);
        assertEquals("test keyword", readabilityUpdate.keyword);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/25
     * This is the testReadabilityUpdate method. Test set and retrieve value from it.
     */
    @Test
    public void ReadabilityUpdateResponse() {
        List<Double> freScores = Arrays.asList(60.0, 70.0);
        List<Double> fkglScores = Arrays.asList(6.0, 7.0);
        ProjectProtocol.ReadabilityUpdateResponse readabilityUpdateResponse = new ProjectProtocol.ReadabilityUpdateResponse(freScores, fkglScores, 65.0, 6.5, "test keyword");

        assertEquals(freScores, readabilityUpdateResponse.fre);
        assertEquals(fkglScores, readabilityUpdateResponse.fkgl);
        assertEquals(Double.valueOf(65.0), readabilityUpdateResponse.avgFRE);
        assertEquals(Double.valueOf(6.5), readabilityUpdateResponse.avgFKGL);
        assertEquals("test keyword", readabilityUpdateResponse.keyword);
    }

        /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/27
     * The method is used to test the sentimentCheck method
     */
    @Test
    public void SentimentCheckTest(){
        YTResponse mock1 = new YTResponse();
        String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
        mock1.setDescription(Description1);
        mock1.setTitle("Title");
        mock1.setVideoId("11111111");
        mock1.setChannelTitle("Channel");
        List<YTResponse> mockList = new ArrayList<>();
        mockList.add(mock1);
        CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
        ProjectProtocol.SentimentCheck stmcheck = new ProjectProtocol.SentimentCheck(Input);
        assertEquals(Input,stmcheck.input);
    }

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/27
     * The method is used to test the SentimentUpdate method
     */
    @Test
    public void SentimentUpdateTest(){
        YTResponse mock1 = new YTResponse();
        String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
        mock1.setDescription(Description1);
        mock1.setTitle("Title");
        mock1.setVideoId("11111111");
        mock1.setChannelTitle("Channel");
        List<YTResponse> mockList = new ArrayList<>();
        mockList.add(mock1);
        CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
        ProjectProtocol.SentimentUpdate stmupdate = new ProjectProtocol.SentimentUpdate(Input);
        assertEquals(Input,stmupdate.input);
    }

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/27
     * The method is used to test the SentimentResponse method
     */
    @Test
    public void SentimentResponseTest(){
        String sentiment = ":-)";
        ProjectProtocol.SentimentResponse stm = new ProjectProtocol.SentimentResponse(sentiment);
        assertEquals(":-)",stm.sentiment);
    }

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/27
     * The method is used to test the SentimentUpdateResponse method
     */
    @Test
    public void SentimentUpdateResponseTest(){
        String sentiment = ":-)";
        ProjectProtocol.SentimentUpdateResponse stm = new ProjectProtocol.SentimentUpdateResponse(sentiment);
        assertEquals(":-)",stm.Sentiment);
    }
}
