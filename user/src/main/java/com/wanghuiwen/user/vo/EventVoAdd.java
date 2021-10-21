package com.wanghuiwen.user.vo;

import com.wanghuiwen.user.model.MmcGroup;

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
    private Long createId;
    List<ImageVo> eventPoster;
    List<MmcGroup> groups;

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
}
