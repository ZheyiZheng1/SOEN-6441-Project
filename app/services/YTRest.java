/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is the YTRest class. It contains YouTube object and provide a searchTopResults method.
 */

package services;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.VideoListResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class YTRest {
    // Parameter
    private static final String APPLICATION_NAME = "SOEN-6441";
    private static final String API_KEY = "";
    private static long MAX_RESULTS = 10;

    private final YouTube youtube;

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Initialize the YouTube object and set the maximum number of results.
     * Default maximum number of results is 10.
     */
    public YTRest(long maxResults) throws GeneralSecurityException, IOException {
        MAX_RESULTS = maxResults;
        // Create a YouTube object
        youtube = new YouTube.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),
                null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Query from YouTube api and return a list of SearchResult.
     * Need to provide a keyword in String.
     */
    public java.util.List<SearchResult> searchTopResults(String keyword) throws IOException {
        // Build a request
        YouTube.Search.List request = youtube.search().list("snippet");
        // Set the key word
        request.setQ(keyword);
        request.setType("video");
        request.setMaxResults(MAX_RESULTS);
        request.setKey(API_KEY);

        // retrieve the result
        SearchListResponse response = request.execute();
        return response.getItems();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Look up the tags based on provided video ID.
     * Returns a list of String.
     */
    public java.util.List<String> getTagsForVideo(String videoId) throws IOException {
        YouTube.Videos.List videoRequest = youtube.videos()
                .list("snippet")
                .setId(videoId)
                .setKey(API_KEY);
        VideoListResponse videoResponse = videoRequest.execute();

        // Retrieve tags
        java.util.List<String> tags = videoResponse.getItems().get(0).getSnippet().getTags();

        return tags;
    }
}
