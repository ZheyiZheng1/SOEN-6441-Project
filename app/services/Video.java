
/*
 * Video class
 * @author Sakshi Mulik - 40295793
 * */

package services;
import scala. collection. immutable. List;

public class Video {
    private String title;
    private String description;
    private String videoUrl;  // This will store the video link (URL)
    private String thumbnailUrl;  // This will store the thumbnail URL for the video

    // Constructor to initialize all fields
    public Video(String title, String description, String videoUrl, String thumbnailUrl) {
        this.title = (title != null && !title.isEmpty()) ? title : "Unknown Title";
        this.description = (description != null && !description.isEmpty()) ? description : "No description available";
        this.videoUrl = (videoUrl != null && !videoUrl.isEmpty()) ? videoUrl : "No URL available";
        this.thumbnailUrl = (thumbnailUrl != null && !thumbnailUrl.isEmpty()) ? thumbnailUrl : "default-thumbnail.png";
    }

    // Default constructor
    public Video() {
        this.title = "Unknown Title";
        this.description = "No description available";
        this.videoUrl = "No URL available";
        this.thumbnailUrl = "default-thumbnail.png";
    }

    public Video(String videoId, String videoTitle) {
        this.title = videoTitle;
        this.videoUrl = "https://www.youtube.com/watch?v=" + videoId;
        this.description = "No description available";
        this.thumbnailUrl = "default-thumbnail.png";
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = (title != null && !title.isEmpty()) ? title : "Unknown Title";
    }

    public void setDescription(String description) {
        this.description = (description != null && !description.isEmpty()) ? description : "No description available";
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = (videoUrl != null && !videoUrl.isEmpty()) ? videoUrl : "No URL available";
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = (thumbnailUrl != null && !thumbnailUrl.isEmpty()) ? thumbnailUrl : "default-thumbnail.png";
    }

    // Setter for videoId, if needed
    public void setVideoId(String videoId) {
        // This method could set the videoId if it's part of the URL or used for other processing
        this.videoUrl = "https://www.youtube.com/watch?v=" + videoId; // Assuming videoId is used to form the video URL
    }

    // Setter for video link (URL)
    public void setVideoLink(String videoUrl) {
        this.videoUrl = (videoUrl != null && !videoUrl.isEmpty()) ? videoUrl : "No URL available";
    }

    // Override toString method for better logging
    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}
