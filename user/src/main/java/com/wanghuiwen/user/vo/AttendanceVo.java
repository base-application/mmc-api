package com.wanghuiwen.user.vo;

public class AttendanceVo {

    /**
     * userId : 1
     * eventId : 1
     * checkInTime : 123
     * checkOutTime : 123
     * isAttendance : true
     * remark : 备注
     * agent : 代出席人
     * agentRole : 代出席人岗位
     * name : 名称
     * picture : 头像
     */

    private Long userId;
    private Long eventId;
    private Long checkInTime;
    private Long checkOutTime;
    private boolean isAttendance;
    private String remark;
    private String agent;
    private String agentRole;
    private String name;
    private String picture;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
