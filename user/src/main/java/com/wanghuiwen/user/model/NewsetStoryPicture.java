package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "newset_story_picture")
public class NewsetStoryPicture implements Serializable {
    @Id
    @Column(name = "picture_id")
    private Long pictureId;

    @Column(name = "newest_story_id")
    private Long newestStoryId;

    /**
     * 图片地址
     */
    @Column(name = "newest_story_picture")
    private String newestStoryPicture;

    private static final long serialVersionUID = 1L;

    /**
     * @return picture_id
     */
    public Long getPictureId() {
        return pictureId;
    }

    /**
     * @param pictureId
     */
    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    /**
     * @return newest_story_id
     */
    public Long getNewestStoryId() {
        return newestStoryId;
    }

    /**
     * @param newestStoryId
     */
    public void setNewestStoryId(Long newestStoryId) {
        this.newestStoryId = newestStoryId;
    }

    /**
     * 获取图片地址
     *
     * @return newest_story_picture - 图片地址
     */
    public String getNewestStoryPicture() {
        return newestStoryPicture;
    }

    /**
     * 设置图片地址
     *
     * @param newestStoryPicture 图片地址
     */
    public void setNewestStoryPicture(String newestStoryPicture) {
        this.newestStoryPicture = newestStoryPicture;
    }
}