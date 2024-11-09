/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/9
 * This is a test class for TextSegment.
 */

import Model.TextSegment;
import org.junit.Test;
import services.YTResponse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class TextSegmentTest {
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/9
     * Test all text segment first constructor.
     */
    @Test
    public void testTextSegmentConstructor() throws Exception {
        TextSegment textSegment = new TextSegment("test", "url");
        assertEquals("test", textSegment.text);
        assertEquals("url", textSegment.url);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/9
     * Test all text segment second constructor.
     */
    @Test
    public void testTextSegmentConstructor2() throws Exception {
        TextSegment textSegment = new TextSegment("test", "url", "123");
        assertEquals("test", textSegment.text);
        assertEquals("url", textSegment.url);
        assertEquals("123", textSegment.videoId);
    }
}
