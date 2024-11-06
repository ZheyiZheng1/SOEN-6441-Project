package Model;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/24
 * This is the TextSegment. It only contains text and url with no method.
 */
public class TextSegment {
    public String text;
    public String url;
    public String videoId; // Add videoId field

    public TextSegment(String text, String url) {
        this.text = text;
        this.url = url;
    }

    public TextSegment(String text, String url, String videoId) {
        this.text = text;
        this.url = url;
        this.videoId = videoId;
    }

    public String getVideoId() {
        return videoId;
    }
}
