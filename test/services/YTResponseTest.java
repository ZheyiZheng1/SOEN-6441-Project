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

        assertEquals("Sample Video", ytResponse.getTitle());
        assertEquals("12345", ytResponse.getVideoId());
        assertEquals("https://www.youtube.com/watch?v=12345", ytResponse.getVideoLink());
        assertEquals("Sample Channel", ytResponse.getChannelTitle());
        assertEquals("abcde", ytResponse.getChannelId());
        assertEquals("https://www.youtube.com/channel/abcde", ytResponse.getChannelProfileLink());
        assertEquals("This is a sample video description.", ytResponse.getDescription());
        assertEquals("https://i.ytimg.com/vi/12345/default.jpg", ytResponse.getThumbnailUrl());
        assertEquals(null, ytResponse.getTags());
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
        System.out.println(ytResponse.toString());
        ytResponse.setTags(null);
        String expectedString = "Sample Video,12345,https://www.youtube.com/watch?v=12345,Sample Channel,abcde,https://www.youtube.com/channel/abcde,This is a sample video description.,https://i.ytimg.com/vi/12345/default.jpg,null";
        assertEquals(expectedString, ytResponse.toString());
    }
}
