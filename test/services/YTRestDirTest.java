/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is a test class for YTRestDir.
 */
package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class YTRestDirTest {

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
    @BeforeEach
    void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
        ytRestDir = spy(new YTRestDir());
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * After each test, close mock.
     */
    @AfterEach
    void tearDown() throws Exception {
        mocks.close();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Test all methods in YTRestDir with mock url and mock JsonResponse,
     * then compare the YTResponse instance with the mock response to see if they have same information.
     */
    @Test
    void testSearchVideosWithMockResponse() throws Exception {
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


}