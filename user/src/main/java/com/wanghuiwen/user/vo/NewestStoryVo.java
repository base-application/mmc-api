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
    private int pushTime;
    private List<ImageVo> poster;

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

    public int getPushTime() {
        return pushTime;
    }

    public void setPushTime(int pushTime) {
        this.pushTime = pushTime;
    }

    public List<ImageVo> getPoster() {
        return poster;
    }

    public void setPoster(List<ImageVo> poster) {
        this.poster = poster;
    }
}
