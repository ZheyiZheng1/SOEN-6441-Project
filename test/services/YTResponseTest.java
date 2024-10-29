package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YTResponseTest {

    private YTResponse ytResponse;

    @BeforeEach
    public void setUp() {
        ytResponse = new YTResponse();
    }

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

        assertEquals("Sample Video", ytResponse.getTitle());
        assertEquals("12345", ytResponse.getVideoId());
        assertEquals("https://www.youtube.com/watch?v=12345", ytResponse.getVideoLink());
        assertEquals("Sample Channel", ytResponse.getChannelTitle());
        assertEquals("abcde", ytResponse.getChannelId());
        assertEquals("https://www.youtube.com/channel/abcde", ytResponse.getChannelProfileLink());
        assertEquals("This is a sample video description.", ytResponse.getDescription());
        assertEquals("https://i.ytimg.com/vi/12345/default.jpg", ytResponse.getThumbnailUrl());
    }

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

        String expectedString = "Sample Video,12345,https://www.youtube.com/watch?v=12345,Sample Channel,abcde,https://www.youtube.com/channel/abcde,This is a sample video description.,https://i.ytimg.com/vi/12345/default.jpg";
        assertEquals(expectedString, ytResponse.toString());
    }
}
