package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "course_video")
public class CourseVideo implements Serializable {
    @Id
    @Column(name = "video_id")
    private Long videoId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "video_title")
    private String videoTitle;

    @Column(name = "video_url")
    private String videoUrl;

    private static final long serialVersionUID = 1L;

    /**
     * @return video_id
     */
    public Long getVideoId() {
        return videoId;
    }

    /**
     * @param videoId
     */
    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    /**
     * @return course_id
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * @param courseId
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * @return video_title
     */
    public String getVideoTitle() {
        return videoTitle;
    }

    /**
     * @param videoTitle
     */
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    /**
     * @return video_url
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * @param videoUrl
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}