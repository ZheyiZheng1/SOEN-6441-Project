/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is the YTResponseTest class. It is a class that test the YTResponse.
 */
package services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YTResponseTest {

    private YTResponse ytResponse;

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Initialize the YTResponse.
     */
    @Before
    public void setUp() {
        ytResponse = new YTResponse();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Test all the setter methods and getter methods by setting value, getting the set value and then compare.
     */
    @Test
    public void testGettersAndSetters() {
        ytResponse.setTitle("Sample Video");
        ytResponse.setVideoId("12345");
        ytResponse.setVideoLink("https://www.youtube.com/watch?v=12345");
        ytResponse.setChannelTitle("Sample Channel");
        ytResponse.setChannelId("abcde");
        ytResponse.setChannelProfileLink("https://www.youtube.com/channel/abcde");
        ytResponse.setDescription("This is a sample video description.");
        ytResponse.setThumbnailUrl("https://i.ytimg.com/vi/12345/default.jpg");
        ytResponse.setTags(null);
        ytResponse.setFre(50.0);
        ytResponse.setFkgl(50.0);
        ytResponse.setkeyword("keyword1");

        assertEquals("Sample Video", ytResponse.getTitle());
        assertEquals("12345", ytResponse.getVideoId());
        assertEquals("https://www.youtube.com/watch?v=12345", ytResponse.getVideoLink());
        assertEquals("Sample Channel", ytResponse.getChannelTitle());
        assertEquals("abcde", ytResponse.getChannelId());
        assertEquals("https://www.youtube.com/channel/abcde", ytResponse.getChannelProfileLink());
        assertEquals("This is a sample video description.", ytResponse.getDescription());
        assertEquals("https://i.ytimg.com/vi/12345/default.jpg", ytResponse.getThumbnailUrl());
        assertEquals(null, ytResponse.getTags());
        assertEquals(50.0, ytResponse.getFkgl());
        assertEquals(50.0, ytResponse.getFre());
        assertEquals("keyword1", ytResponse.getKeyword());
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Test toString method. Set all the values and then retrieve all information using toString(). Lastly, compare the value.
     */
    @Test
    public void testToString() {
        ytResponse.setTitle("Sample Video");
        ytResponse.setVideoId("12345");
        ytResponse.setVideoLink("https://www.youtube.com/watch?v=12345");
        ytResponse.setChannelTitle("Sample Channel");
        ytResponse.setChannelId("abcde");
        ytResponse.setChannelProfileLink("https://www.youtube.com/channel/abcde");
        ytResponse.setDescription("This is a sample video description.");
        ytResponse.setThumbnailUrl("https://i.ytimg.com/vi/12345/default.jpg");
        //System.out.println(ytResponse.toString());
        ytResponse.setTags(null);
        String expectedString = "Sample Video,12345,https://www.youtube.com/watch?v=12345,Sample Channel,abcde,https://www.youtube.com/channel/abcde,This is a sample video description.,https://i.ytimg.com/vi/12345/default.jpg,null";
        assertEquals(expectedString, ytResponse.toString());
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Test toHTMLString method. Set all the values and then retrieve all information using toHTMLString(). Lastly, compare the value.
     */
    @Test
    public void testToHTMLString() {
        ytResponse.setTitle("Sample Video");
        ytResponse.setVideoId("12345");
        ytResponse.setVideoLink("https://www.youtube.com/watch?v=12345");
        ytResponse.setChannelTitle("Sample Channel");
        ytResponse.setChannelId("abcde");
        ytResponse.setChannelProfileLink("https://www.youtube.com/channel/abcde");
        ytResponse.setDescription("This is a sample video description.");
        ytResponse.setThumbnailUrl("https://i.ytimg.com/vi/12345/default.jpg");
        //System.out.println(ytResponse.toString());
        ytResponse.setTags(null);
        ytResponse.setFre(50.0);
        ytResponse.setFkgl(50.0);
        String html = "Title: ";
        html += "<a href=\"https://www.youtube.com/watch?v=12345\">Sample Video</a>";
        html += ", Channel: <a href=\"https://www.youtube.com/channel/abcde\">Sample Channel</a>";
        html += ", Description: \"This is a sample video description.\".";
        html += "Flesch-Kincaid Grade Level= "+ 50.0 + ", ";
        html += "Flesch Reading Ease Score= "+ 50.0 + ".";
        html += "<a href=\"/tagDetails?videoId=12345\">Tags</a>";
        html += "<img src=\"https://i.ytimg.com/vi/12345/default.jpg\" alt=\"Thumbnail Image\">";
        assertEquals(html, ytResponse.toHTMLString());
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/25
     * Test equals method.
     */
    @Test
    public void testEquals() {
        YTResponse ytResponse1 = new YTResponse();
        ytResponse1.setTitle("Sample Video");
        ytResponse1.setVideoId("12345");
        ytResponse1.setVideoLink("https://www.youtube.com/watch?v=12345");
        ytResponse1.setChannelTitle("Sample Channel");
        ytResponse1.setChannelId("abcde");
        ytResponse1.setChannelProfileLink("https://www.youtube.com/channel/abcde");
        ytResponse1.setDescription("This is a sample video description.");
        ytResponse1.setThumbnailUrl("https://i.ytimg.com/vi/12345/default.jpg");
        ytResponse1.setTags(null);
        ytResponse1.setFre(50.0);
        ytResponse1.setFkgl(50.0);
        ytResponse1.setkeyword("keyword1");

        YTResponse ytResponse2 = new YTResponse();
        ytResponse2.setTitle("Sample Video");
        ytResponse2.setVideoId("12345");
        ytResponse2.setVideoLink("https://www.youtube.com/watch?v=12345");
        ytResponse2.setChannelTitle("Sample Channel");
        ytResponse2.setChannelId("abcde");
        ytResponse2.setChannelProfileLink("https://www.youtube.com/channel/abcde");
        ytResponse2.setDescription("This is a sample video description.");
        ytResponse2.setThumbnailUrl("https://i.ytimg.com/vi/12345/default.jpg");
        ytResponse2.setTags(null);
        ytResponse2.setFre(50.0);
        ytResponse2.setFkgl(50.0);
        ytResponse2.setkeyword("keyword1");
        System.out.println(ytResponse1.toString());
        System.out.println(ytResponse2.toString());
        assertTrue(ytResponse1.equals(ytResponse2));
    }
}
