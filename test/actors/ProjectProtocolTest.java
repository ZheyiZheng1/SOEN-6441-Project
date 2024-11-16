package actors;

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
}
