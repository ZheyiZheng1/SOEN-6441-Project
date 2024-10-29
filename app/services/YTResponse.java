/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is the YTResponse class. It is a class that contains all information about a video.
 */
package services;

public class YTResponse {
    private String title;
    private String videoId;
    private String videoLink;
    private String channelTitle;
    private String channelId;
    private String channelProfileLink;
    private String description;
    private String thumbnailUrl;

    public YTResponse() {
        super();
    }

    // to string method
    public String toString(){
        return title+","+videoId+","+videoLink+","+channelTitle+","+channelId+","+channelProfileLink+","+description+","+thumbnailUrl;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getVideoId() {
        return videoId;
    }
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
    public String getVideoLink() {
        return videoLink;
    }
    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
    public String getChannelTitle() {
        return channelTitle;
    }
    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }
    public String getChannelId() {
        return channelId;
    }
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    public String getChannelProfileLink() {
        return channelProfileLink;
    }
    public void setChannelProfileLink(String channelProfileLink) {
        this.channelProfileLink = channelProfileLink;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }


}
