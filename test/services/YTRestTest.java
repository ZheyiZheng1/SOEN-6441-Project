/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is the test class for YTRest.
 */
package services;

import com.google.api.services.youtube.model.SearchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class YTRestTest {

    private YTRest ytRest;

    @BeforeEach
    public void setUp() throws GeneralSecurityException, IOException {
        // Create a new instance of YTRest
        ytRest = new YTRest(2);
    }

    @Test
    public void testSearchTopResults() throws IOException {
        String keyword = "java";

        // Execute the search
        List<SearchResult> results = ytRest.searchTopResults(keyword);

        // Assertions
        assertNotNull(results, "The search results should not be null");
        assertFalse(results.isEmpty(), "The search results should not be empty");

        // Optional: Print the results for manual verification
        for (SearchResult result : results) {
            // Each match must include the title with a hyperlink to the video, the channel title with a hyperlink to
            // the channel profile page (see details below in individual tasks), a hyperlink to the video tags,  the
            // description, and the default thumbnail.
            String videoId = result.getId().getVideoId();
            System.out.println("Title: " + result.getSnippet().getTitle());
            System.out.println("Video link: " + "https://www.youtube.com/watch?v=" + videoId);
            System.out.println("Channel Title: " + result.getSnippet().getChannelTitle());
            System.out.println("Channel profile link: " + "https://www.youtube.com/channel/" + result.getId().getChannelId());
            System.out.println("Description: " + result.getSnippet().getDescription());
            System.out.println("Default Thumbnails: " + result.getSnippet().getThumbnails());

            // Get tags for the video
            List<String> tags = ytRest.getTagsForVideo(videoId);
            // Print the first tag, if it exists
            if (tags != null && !tags.isEmpty()) {
                String firstTag = tags.get(0);
                System.out.println("Tag: " + firstTag);
                System.out.println("Tag Link: " + "https://www.youtube.com/results?search_query=" + firstTag + ")");
            }
            System.out.println("----------------------------------------------------------------");
        }
    }
}