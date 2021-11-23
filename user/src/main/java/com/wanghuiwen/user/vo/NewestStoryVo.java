package com.wanghuiwen.user.vo;

import java.util.List;

public class NewestStoryVo {


    /**
     * description :
     * storyId : 1
     * link :
     * poster : [{"newestStoryId":1,"newestStoryPicture":""}]
     * pushTime : 1
     */

    private String description;
    private Long storyId;
    private String link;
    private String title;
    private Long pushTime;
    private List<ImageVo> poster;
    private String cover;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getPushTime() {
        return pushTime;
    }

    public void setPushTime(Long pushTime) {
        this.pushTime = pushTime;
    }

    public List<ImageVo> getPoster() {
        return poster;
    }

    public void setPoster(List<ImageVo> poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
