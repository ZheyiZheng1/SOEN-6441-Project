/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is the YTResponse class. It is a class that contains all information about a video.
 */
package services;

import java.util.List;

public class YTResponse {
    private String title;
    private String videoId;
    private String videoLink;
    private String channelTitle;
    private String channelId;
    private String channelProfileLink;
    private String description;
    private String thumbnailUrl;
    private int videoCount;
    private List<String> tags;  // Added tags field
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Constructor method that only call super();.
     */
    public YTResponse() {
        super();
    }
    /*
     *
     * @author Sakshi Mulik - 40295793
     * */
    public YTResponse(String title, String description, int videoCount, String youtubeLink, String thumbnailUrl) {
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a string that combine all information of the class.
     */
    public String toString(){
        return title+","+videoId+","+videoLink+","+channelTitle+","+channelId+","+channelProfileLink+","+description+","+thumbnailUrl+","+tags;
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a string of title.
     */
    public String getTitle() {
        return title;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param title set the title.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a string of video id.
     */
    public String getVideoId() {
        return videoId;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param videoId set the videoId.
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a string of video link.
     */
    public String getVideoLink() {
        return videoLink;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param videoLink set the videoId.
     */
    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a string of channel title.
     */
    public String getChannelTitle() {
        return channelTitle;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param channelTitle set the videoId.
     */
    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a string of channel id.
     */
    public String getChannelId() {
        return channelId;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param channelId set the channel id.
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a string of Channel profile link.
     */
    public String getChannelProfileLink() {
        return channelProfileLink;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param channelProfileLink set the Channel profile link.
     */
    public void setChannelProfileLink(String channelProfileLink) {
        this.channelProfileLink = channelProfileLink;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a string of video description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param description set the video description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a string of thumbnail Url.
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param thumbnailUrl set the video thumbnailUrl.
     */
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }



    /**
     * @author: Pulkit Bansal - 40321488
     * Created: 2024/10/29
     * returns the tags.
     */
    public List<String> getTags() {
        return tags;
    }
    /**
     * @author: Pulkit Bansal - 40321488
     * Created: 2024/10/29
     * @param tags set the video tags.
     */

    public void setTags(List<String> tags) {
        this.tags = tags;
    }


    /**
     * @author: Sakshi Mulik - 40295793
     *  set the videocount .
     */
    public int getVideoCount() {
        return videoCount;
    }
    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

}
