package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "newest_story")
public class NewestStory implements Serializable {
    @Id
    @Column(name = "story_id")
    private Long storyId;

    private String description;

    private String link;

    @Column(name = "push_time")
    private Long pushTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return story_id
     */
    public Long getStoryId() {
        return storyId;
    }

    /**
     * @param storyId
     */
    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return push_time
     */
    public Long getPushTime() {
        return pushTime;
    }

    /**
     * @param pushTime
     */
    public void setPushTime(Long pushTime) {
        this.pushTime = pushTime;
    }
}