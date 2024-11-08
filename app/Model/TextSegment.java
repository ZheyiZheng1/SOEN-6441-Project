package Model;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/24
 * This is the TextSegment model. It only contains text and url that use to pass information from controller to view.
 */
public class TextSegment {
    public String text;
    public String url;
    public String videoId;

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     * Constructor method.
     * @param text a string of text, url a string of url
     */
    public TextSegment(String text, String url) {
        this.text = text;
        this.url = url;
    }

    public TextSegment(String text, String url, String videoId) {
        this.text = text;
        this.url = url;
        this.videoId = videoId;
    }
}
