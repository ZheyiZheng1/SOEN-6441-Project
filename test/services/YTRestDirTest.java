/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is a test class for YTRestDir.
 */
package services;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class YTRestDirTest {

    @Mock
    HttpURLConnection mockConnection;

    private YTRestDir ytRestDir;
    private AutoCloseable mocks;

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Before each test, open mocks and a spy of YTRestDir.
     * spy allows us to use both YTRestDir methods and mock methods.
     */
    @Before
    public void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
        ytRestDir = spy(new YTRestDir());
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * After each test, close mock.
     */
    @After
    public void tearDown() throws Exception {
        mocks.close();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Test all methods in YTRestDir with mock url and mock JsonResponse,
     * then compare the YTResponse instance with the mock response to see if they have same information.
     */
    @Test
    public void testSearchVideosWithMockResponse() throws Exception {
        String mockUrl = "https://mocked_url_for_testing";
        String mockJsonResponse = "{ \"items\": [{ \"snippet\": { \"title\": \"Test Video\", \"channelTitle\": \"Test Channel\", \"channelId\": \"12345\", \"description\": \"Test Description\", \"thumbnails\": { \"default\": { \"url\": \"https://example.com/image.jpg\" } } }, \"id\": { \"videoId\": \"test123\" } }] }";

        // Mock the getHttpURLConnection method to return mockConnection
        doReturn(mockConnection).when(ytRestDir).getHttpURLConnection(new URI(mockUrl));

        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        InputStream stream = new ByteArrayInputStream(mockJsonResponse.getBytes());
        when(mockConnection.getInputStream()).thenReturn(stream);

        List<YTResponse> result = ytRestDir.searchVideosAsynch("keyword", mockUrl, "10")
                .toCompletableFuture()
                // This join method is just for test purpose, should not appear in the actual project.
                .join();

        assertEquals(1, result.size());
        YTResponse response = result.get(0);
        System.out.println(response);
        assertEquals("Test Video", response.getTitle());
        assertEquals("Test Channel", response.getChannelTitle());
        assertEquals("12345", response.getChannelId());
        assertEquals("https://example.com/image.jpg", response.getThumbnailUrl());
    }

    /**
     * @author: Pulkit Bansal - 40321488
     * Test for getVideoDetails when video exists
     */
    @Test
    public void testGetVideoDetailsWithValidResponse() throws Exception {
        String videoId = "test123";
        String mockJsonResponse = "{ \"items\": [ { \"id\": \"test123\", \"snippet\": { \"title\": \"Test Video\", \"channelTitle\": \"Test Channel\", \"channelId\": \"12345\", \"description\": \"Test Description\", \"tags\": [\"tag1\", \"tag2\"] } } ] }";
        String mockUrl = "https://mocked_url_for_testing";

        // Mock the getHttpURLConnection method to return mockConnection
        doReturn(mockConnection).when(ytRestDir).getHttpURLConnection(any(URI.class));
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);

        // Mock the input stream with the valid JSON response
        InputStream stream = new ByteArrayInputStream(mockJsonResponse.getBytes());
        when(mockConnection.getInputStream()).thenReturn(stream);

        // Call the method under test
        YTResponse videoDetails = ytRestDir.getVideoDetails(videoId).toCompletableFuture().join();

        // Validate the response
        assertNotNull("Video details should not be null", videoDetails);
        assertEquals("Test Video", videoDetails.getTitle());
        assertEquals("Test Channel", videoDetails.getChannelTitle());
        assertEquals("12345", videoDetails.getChannelId());
        assertEquals("Test Description", videoDetails.getDescription());
        assertEquals(List.of("tag1", "tag2"), videoDetails.getTags());
    }

    /**
     * @author: Pulkit Bansal - 40321488
     * Test for getVideoDetails with an invalid videoId (no items in response)
     */
    @Test
    public void testGetVideoDetailsWithInvalidVideoId() throws Exception {
        String videoId = "invalid_id";
        String mockJsonResponse = "{ \"items\": [] }"; // Empty items array
        String mockUrl = "https://mocked_url_for_testing";

        doReturn(mockConnection).when(ytRestDir).getHttpURLConnection(new URI(mockUrl));
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        InputStream stream = new ByteArrayInputStream(mockJsonResponse.getBytes());
        when(mockConnection.getInputStream()).thenReturn(stream);

        YTResponse videoDetails = ytRestDir.getVideoDetails(videoId).toCompletableFuture().join();

        assertNull(videoDetails); // No video found, should return null
    }

    /**
     * @author: Pulkit Bansal - 40321488
     * Test for parseVideoDetails with a valid JSON response
     */
    @Test
    public void testParseVideoDetails() {
        String mockJsonResponse = "{ \"items\": [ { \"id\": \"id\", \"snippet\": { \"title\": \"Test Video\", \"channelTitle\": \"Test Channel\", \"channelId\": \"12345\", \"description\": \"Test Description\", \"tags\": [\"tag1\", \"tag2\"] } } ] }";
        YTResponse response = ytRestDir.parseVideoDetails(mockJsonResponse);

        assertNotNull(response);
        assertEquals("id", response.getVideoId());
        assertEquals("Test Video", response.getTitle());
        assertEquals("Test Channel", response.getChannelTitle());
        assertEquals("12345", response.getChannelId());
        assertEquals("Test Description", response.getDescription());
        assertEquals(List.of("tag1", "tag2"), response.getTags());
    }


    /**
     * @author: Pulkit Bansal - 40321488
     * Test for searchVideos with valid response.
     */
    @Test
    public void testSearchVideosWithValidResponse() throws Exception {
        String keyword = "test";
        String mockJsonResponse = "{ \"items\": [{ \"id\": { \"videoId\": \"test123\" }, \"snippet\": { \"title\": \"Test Video\", \"channelTitle\": \"Test Channel\", \"channelId\": \"12345\", \"description\": \"Test Description\" } }] }";

        doReturn(mockConnection).when(ytRestDir).getHttpURLConnection(any(URI.class));
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        InputStream stream = new ByteArrayInputStream(mockJsonResponse.getBytes());
        when(mockConnection.getInputStream()).thenReturn(stream);

        CompletableFuture<List<YTResponse>> response = ytRestDir.searchVideos(keyword);
        List<YTResponse> videos = response.toCompletableFuture().join();

        // Assertions
        assertNotNull("Search results should not be null", videos);
        assertEquals(1, videos.size());
        YTResponse video = videos.get(0);
        assertEquals("Test Video", video.getTitle());
        assertEquals("Test Channel", video.getChannelTitle());
        assertEquals("12345", video.getChannelId());
    }

    /**
     * @author: Pulkit Bansal - 40321488
     * Test for searchVideos with invalid response (empty items).
     */
    @Test
    public void testSearchVideosWithInvalidResponse() throws Exception {
        String keyword = "nonexistent";
        String mockJsonResponse = "{ \"items\": [] }"; // Empty items array

        doReturn(mockConnection).when(ytRestDir).getHttpURLConnection(any(URI.class));
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        InputStream stream = new ByteArrayInputStream(mockJsonResponse.getBytes());
        when(mockConnection.getInputStream()).thenReturn(stream);

        CompletableFuture<List<YTResponse>> response = ytRestDir.searchVideos(keyword);
        List<YTResponse> videos = response.toCompletableFuture().join();

        assertNotNull("Search results should not be null", videos);
        assertTrue(videos.isEmpty()); // Expect empty list for no search results
    }

    /**
     * @author: Pulkit Bansal - 40321488
     * Test for parseSearchResults with valid response.
     */
    @Test
    public void testParseSearchResults() {
        String mockJsonResponse = "{ \"items\": [{ \"id\": { \"videoId\": \"test123\" }, \"snippet\": { \"title\": \"Test Video\", \"channelTitle\": \"Test Channel\", \"channelId\": \"12345\", \"description\": \"Test Description\" } }] }";

        List<YTResponse> results = ytRestDir.parseSearchResults(mockJsonResponse);

        // Assertions
        assertNotNull("Parsed results should not be null", results);
        assertEquals(1, results.size());
        YTResponse video = results.get(0);
        assertEquals("Test Video", video.getTitle());
        assertEquals("Test Channel", video.getChannelTitle());
        assertEquals("12345", video.getChannelId());
    }

    /**
     * @author: Pulkit Bansal - 40321488
     * Test for parseSearchResults with empty response.
     */
    @Test
    public void testParseSearchResultsWithEmptyResponse() {
        String mockJsonResponse = "{ \"items\": [] }";

        List<YTResponse> results = ytRestDir.parseSearchResults(mockJsonResponse);

        // Assertions
        assertNotNull("Parsed results should not be null", results);
        assertTrue("Expected an empty result list", results.isEmpty());
    }

    /**
     * @author: Pulkit Bansal - 40321488
     * Test for parseVideoDetails with empty response.
     */
    @Test
    public void testParseVideoDetailsWithEmptyResponse() {
        String mockJsonResponse = "{ \"items\": [] }";

        YTResponse videoDetails = ytRestDir.parseVideoDetails(mockJsonResponse);

        assertNull("Expected null for empty response", videoDetails);
    }



    @Test
    public void testIOException_HTTPErrorCode() throws Exception {
        // Mock HttpURLConnection to simulate a non-200 response code
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_INTERNAL_ERROR); // 500

        String validUrl = "https://www.googleapis.com/youtube/v3/search?q=java&key=API_KEY";

        // Mocking the behavior of HttpURLConnection to simulate an error response
        when(mockConnection.getInputStream()).thenThrow(new IOException("HTTP error code: 500"));

        // Here we test the IOException for non-200 status code response
        assertThrows(IOException.class, () -> {
            ytRestDir.searchVideos("java", validUrl, "10");
        });
    }
    @Test
    public void testURISyntaxException2() {

        String invalidUrl = "https://www.example.com/search?query=spaces in url"; // an invalid URL containing spaces
        String keyword = "test";
        String maxResult = "5";

        IOException exception = assertThrows(IOException.class, () -> {
            ytRestDir.searchVideos(keyword, invalidUrl, maxResult);
        });

        assertTrue(exception.getMessage().contains("Invalid URL"));
    }
}