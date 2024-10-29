/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is a test class for YTRestDir.
 */
package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class YTRestDirTest {

    private YTRestDir ytRest;

    @BeforeEach
    public void setUp() {
        ytRest = new YTRestDir();
    }

    @Test
    public void testSearchVideos() {
        String keyword = "java";
        try {
            List<YTResponse> responses = ytRest.searchVideos(keyword);
            System.out.println(responses);
            // Assertions
            assertNotNull(responses);
            assertFalse(responses.isEmpty());

            YTResponse response = responses.get(0);
            assertNotNull(response.getTitle());
            assertNotNull(response.getVideoId());
            assertNotNull(response.getChannelTitle());
            assertNotNull(response.getDescription());
            assertNotNull(response.getThumbnailUrl());
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        }
    }
}