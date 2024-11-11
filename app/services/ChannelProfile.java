/*
 * ChannelProfile class
 * @author Sakshi Mulik - 40295793
 * */

package services;

import com.google.api.services.youtube.model.Video;

import java.util.ArrayList;
import java.util.List;

public class ChannelProfile {
    private String title;
    private String description;
    private String country;
    private int videoCount;
    private String youtubeLink;  // Renamed to youtubeLink (Channel Profile Link)
    private String thumbnailUrl;

    // Constructor with parameters to initialize the fields
    public ChannelProfile(String title, String description, String country, int videoCount, String youtubeLink, String thumbnailUrl) {
        this.title = (title != null && !title.isEmpty()) ? title : "Unknown Title";
        this.description = (description != null && !description.isEmpty()) ? description : "No description available";
        this.country = (country != null && !country.isEmpty()) ? country : "Unknown";
        this.videoCount = Math.max(videoCount, 0);  // Ensure video count is not negative
        this.youtubeLink = (youtubeLink != null && !youtubeLink.isEmpty()) ? youtubeLink : "No link available";
        this.thumbnailUrl = (thumbnailUrl != null && !thumbnailUrl.isEmpty()) ? thumbnailUrl : "default-thumbnail.png";
    }

    // Default constructor to handle cases when no arguments are passed
    public ChannelProfile() {
        this.title = "Unknown Title";
        this.description = "No description available";
        this.country = "Unknown";
        this.videoCount = 0;
        this.youtubeLink = "No link available";
        this.thumbnailUrl = "default-thumbnail.png";
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    // Setter methods with validation
    public void setTitle(String title) {
        this.title = (title != null && !title.isEmpty()) ? title : "Unknown Title";
    }

    public void setDescription(String description) {
        this.description = (description != null && !description.isEmpty()) ? description : "No description available";
    }

    public void setCountry(String country) {
        this.country = (country != null && !country.isEmpty()) ? country : "Unknown";
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = Math.max(videoCount, 0);  // Ensuring the video count is non-negative
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = (thumbnailUrl != null && !thumbnailUrl.isEmpty()) ? thumbnailUrl : "default-thumbnail.png";
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = (youtubeLink != null && !youtubeLink.isEmpty()) ? youtubeLink : "No link available";
    }

    // Setter for channel profile link (sets the youtubeLink field)
    public void setChannelProfileLink(String channelProfileLink) {
        this.youtubeLink = (channelProfileLink != null && !channelProfileLink.isEmpty()) ? channelProfileLink : "No link available";
    }

    // Method to get the channel profile link
    public String getChannelProfileLink() {
        return this.youtubeLink;  // Return the YouTube link directly
    }

    // Method to return a YTResponse object
    public YTResponse getYTResponse() {
        // Return a new YTResponse object with the data from this ChannelProfile
        return new YTResponse(this.title, this.description, this.videoCount, this.youtubeLink, this.thumbnailUrl);
    }

    public List<Video> getVideos() {
        List<Video> videos = new ArrayList<>();

        // Add dummy videos for now (you can replace this with actual video fetching logic)
        for (int i = 1; i <= videoCount; i++) {
            Video video = new Video();
            videos.add(video);
        }

        return videos;
    }
}
