/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/16
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
    private double fre;
    private double fkgl;
    private String keyword;

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
     * @return a string that combine all information of the class in HTML format.
     */
    public String toHTMLString(){
        String html = "Title: ";
        html += "<a href=\""+ videoLink +"\">"+title+"</a>";
        html += ", Channel: <a href=\""+ channelProfileLink + "\">" + channelTitle+"</a>";
        html += ", Description: \""+ description + "\".";
        html += "Flesch-Kincaid Grade Level= "+ fkgl + ", ";
        html += "Flesch Reading Ease Score= "+ fre + ".";
        html += "<a href=\"TODO\">Tags</a>";
        html += "<img src=\""+thumbnailUrl+"\" alt=\"Thumbnail Image\">";
        return html;
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
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a double of fre value.
     */
    public double getFre(){return fre;}
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param fre set the fre value.
     */
    public void setFre(double fre){this.fre=fre;}
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a double of fkgl value.
     */
    public double getFkgl(){return fkgl;}
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param fkgl set the fkgl value.
     */
    public void setFkgl(double fkgl){this.fkgl=fkgl;}
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @return a String of keyword value.
     */
    public String getKeyword(){return keyword;}
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * @param keyword set the keyword value.
     */
    public void setkeyword(String keyword){this.keyword=keyword;}

    public boolean equals(YTResponse target){
        if(!target.getTitle().equals(this.title)) {return false;}
        if(!target.getVideoId().equals(this.videoId)) {return false;}
        if(!target.getVideoLink().equals(this.videoLink)) {return false;}
        if(!target.getChannelTitle().equals(this.channelTitle)) {return false;}
        if(!target.getChannelId().equals(this.channelId)) {return false;}
        if(!target.getChannelProfileLink().equals(this.channelProfileLink)) {return false;}
        if(!target.getDescription().equals(this.description)) {return false;}
        if(!target.getThumbnailUrl().equals(this.thumbnailUrl)) {return false;}
        return true;
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
