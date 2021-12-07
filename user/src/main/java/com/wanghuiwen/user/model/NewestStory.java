package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "newest_story")
public class NewestStory implements Serializable {
    @Id
    @Column(name = "story_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storyId;

    /**
     * 描述
     */
    private String description;

    /**
     * 链接
     */
    private String link;

    /**
     * 发布时间
     */
    @Column(name = "push_time")
    private Long pushTime;

    /**
     * 标题
     */
    private String title;

    /**
     * 封面
     */
    private String cover;

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
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取链接
     *
     * @return link - 链接
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置链接
     *
     * @param link 链接
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 获取发布时间
     *
     * @return push_time - 发布时间
     */
    public Long getPushTime() {
        return pushTime;
    }

    /**
     * 设置发布时间
     *
     * @param pushTime 发布时间
     */
    public void setPushTime(Long pushTime) {
        this.pushTime = pushTime;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取封面
     *
     * @return cover - 封面
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置封面
     *
     * @param cover 封面
     */
    public void setCover(String cover) {
        this.cover = cover;
    }
}