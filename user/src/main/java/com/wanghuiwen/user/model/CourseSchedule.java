package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "course_schedule")
public class CourseSchedule implements Serializable {
    @Id
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "schedule_url")
    private String scheduleUrl;

    @Column(name = "schedule_time")
    private Long scheduleTime;

    @Column(name = "schedule_title")
    private String scheduleTitle;

    @Column(name = "schedule_venue")
    private String scheduleVenue;

    private static final long serialVersionUID = 1L;

    /**
     * @return schedule_id
     */
    public Long getScheduleId() {
        return scheduleId;
    }

    /**
     * @param scheduleId
     */
    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
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
     * @return schedule_url
     */
    public String getScheduleUrl() {
        return scheduleUrl;
    }

    /**
     * @param scheduleUrl
     */
    public void setScheduleUrl(String scheduleUrl) {
        this.scheduleUrl = scheduleUrl;
    }

    /**
     * @return schedule_time
     */
    public Long getScheduleTime() {
        return scheduleTime;
    }

    /**
     * @param scheduleTime
     */
    public void setScheduleTime(Long scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    /**
     * @return schedule_title
     */
    public String getScheduleTitle() {
        return scheduleTitle;
    }

    /**
     * @param scheduleTitle
     */
    public void setScheduleTitle(String scheduleTitle) {
        this.scheduleTitle = scheduleTitle;
    }

    /**
     * @return schedule_venue
     */
    public String getScheduleVenue() {
        return scheduleVenue;
    }

    /**
     * @param scheduleVenue
     */
    public void setScheduleVenue(String scheduleVenue) {
        this.scheduleVenue = scheduleVenue;
    }
}