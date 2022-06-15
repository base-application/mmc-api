package com.wanghuiwen.user.vo;

import com.wanghuiwen.user.model.Grade;
import com.wanghuiwen.user.model.MmcGroup;

import java.math.BigDecimal;
import java.util.List;

public class EventVoAdd {


    /**
     * eventId : 1
     * eventTitle : 活动标题
     * eventDescription : 活动介绍
     * eventStartTime : 123123
     * eventEndTime : 12323
     * eventLocation : 活动位置
     * eventMapLink : 地图连接
     * eventType :
     */

    private Long eventId;
    private String eventTitle;
    private String eventDescription;
    private Long eventStartTime;
    private Long eventEndTime;
    private String eventLocation;
    private String eventMapLink;
    private String eventType;
    private String thumbnail;
    private Long createId;
    private Boolean attend;
    private Boolean join;
    private Long checkInTime;
    private Long checkOutTime;
    private BigDecimal point;
    List<ImageVo> eventPoster;
    List<MmcGroup> groups;
    List<Grade> grades;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Long getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Long eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Long getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Long eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventMapLink() {
        return eventMapLink;
    }

    public void setEventMapLink(String eventMapLink) {
        this.eventMapLink = eventMapLink;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public List<ImageVo> getEventPoster() {
        return eventPoster;
    }

    public void setEventPoster(List<ImageVo> eventPoster) {
        this.eventPoster = eventPoster;
    }

    public List<MmcGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<MmcGroup> groups) {
        this.groups = groups;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Boolean getAttend() {
        return attend;
    }

    public void setAttend(Boolean attend) {
        this.attend = attend;
    }

    public Boolean getJoin() {
        return join;
    }

    public void setJoin(Boolean join) {
        this.join = join;
    }

    public Long getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Long checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Long getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Long checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
