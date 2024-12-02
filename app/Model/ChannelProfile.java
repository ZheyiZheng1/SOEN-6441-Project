package Model;

import services.YTResponse;
import java.util.List;


/**
 * @author: Sakshi Mulik - 40295793
 * Created: 2024/11/27
 * This class represents a channel profile with various attributes such as channel ID, title, description,
 * subscribers count, channel URL, and the latest videos.
 */
public class ChannelProfile {
    private String channelId;  // Assuming channelId is different from channelUrl
    private String title;
    private String description;
    private String subscribersCount;
    private String channelUrl;
    private List<VideoData> lastVideos;

    /**
     * Constructor to initialize the ChannelProfile object with necessary attributes.
     * @param channelId The ID of the channel.
     * @param title The title of the channel.
     * @param description A brief description of the channel.
     * @param latestVideos List of the latest videos from the channel.
     */
    public ChannelProfile(String channelId, String title, String profileLink, String description, String thumbnailUrl, List<YTResponse> latestVideos) {
        this.channelId = channelId;
        this.title = title;
        this.description = description;
        this.subscribersCount = subscribersCount;
        this.channelUrl = channelUrl;
        this.lastVideos = lastVideos;
    }

    // Default constructor
    public ChannelProfile() {
    }

    public ChannelProfile(String channelId, String exampleTitle, String s) {
    }

    public ChannelProfile(String channelID, String channelTitle, String subscriberCount, int i) {
    }



    /**
     * Created: 2024/11/27
     * Getter for channelId.
     * @return The channel ID.
     */
    public String getChannelId() {
        return channelId;  // Return the actual channelId
    }

    public String getTitle() {
        return title;  // Return title
    }

    public String getDescription() {
        return description;  // Return description
    }

    public String getSubscribersCount() {
        return subscribersCount;  // Return subscribersCount
    }

    public String getChannelUrl() {
        return channelUrl;  // Return the channelUrl
    }

    public List<VideoData> getLastVideos() {
        return lastVideos;  // Return the list of last videos
    }

    // Setters (if needed for testing or other operations)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubscribersCount(String subscribersCount) {
        this.subscribersCount = subscribersCount;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }

    public void setLastVideos(List<VideoData> lastVideos) {
        this.lastVideos = lastVideos;
    }

    public void setThumbnailUrl(String s) {
    }

    public void setViewCount(int viewCount) {
    }

    public void setSubscriberCount(int subscriberCount) {
    }

    public void setVideoCount(String videoCount) {
    }

    public short getChannelTitle() {
        return 0;
    }

    public short getSubscriberCount() {
        return 0;
    }

    public short getVideoCount() {
        return 0;
    }

    public short getViewCount() {
        return 0;
    }

    /**
     * Nested static class representing video data within the channel profile.
     * Contains video title and video link.
     */
    public static class VideoData {
        private String title;
        private String videoLink;

        /**
         * Constructor for creating a VideoData object.
         * @param title The title of the video.
         * @param videoLink The link to the video.
         */
        public VideoData(String title, String videoLink) {
            this.title = title;
            this.videoLink = videoLink;
        }
        /**
         * Getter for video title.
         * @return The title of the video.
         */
        public String getTitle() {
            return title;
        }
        /**
         * Getter for video link.
         * @return The URL of the video.
         */
        public String getVideoLink() {
            return videoLink;
        }
    }
}
