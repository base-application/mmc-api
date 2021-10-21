package com.wanghuiwen.user.vo;

public class CheckHistoryVo {

    /**
     * eventTitle : 活动标题
     * eventDescription : 活动介绍
     * eventStartTime : 1
     * eventEndTime : 1
     * eventLocation : 活动位置
     * eventMapLink : 地图连接
     * userId : 1
     * eventId : 1
     * checkInTime : 1
     * checkOutTime : 1
     * isAttendance : true
     * remark : 备注
     * agent : 代出席人
     * agentRole : 代出席人岗位
     * absentReason : 缺席原因
     */

    private String eventTitle;
    private String eventDescription;
    private Long eventStartTime;
    private Long eventEndTime;
    private String eventLocation;
    private String eventMapLink;
    private Long userId;
    private Long eventId;
    private Long checkInTime;
    private Long checkOutTime;
    private boolean isAttendance;
    private String remark;
    private String agent;
    private String agentRole;
    private String absentReason;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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

    public boolean isIsAttendance() {
        return isAttendance;
    }

    public void setIsAttendance(boolean isAttendance) {
        this.isAttendance = isAttendance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgentRole() {
        return agentRole;
    }

    public void setAgentRole(String agentRole) {
        this.agentRole = agentRole;
    }

    public String getAbsentReason() {
        return absentReason;
    }

    public void setAbsentReason(String absentReason) {
        this.absentReason = absentReason;
    }
}
