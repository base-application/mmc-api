package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

public class Attendance implements Serializable {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "event_id")
    private Long eventId;

    /**
     * 签到时间
     */
    @Column(name = "check_in_time")
    private Long checkInTime;

    /**
     * 签退时间
     */
    @Column(name = "check_out_time")
    private Long checkOutTime;

    /**
     * 是否出席
     */
    @Column(name = "is_attendance")
    private Boolean isAttendance;

    /**
     * 备注
     */
    private String remark;

    /**
     * 代出席人
     */
    private String agent;

    /**
     * 代出席人岗位
     */
    @Column(name = "agent_role")
    private String agentRole;

    /**
     * 缺席原因
     */
    @Column(name = "absent_reason")
    private String absentReason;

    /**
     * 是否留言
     */
    @Column(name = "facebook_comment")
    private Boolean facebookComment;

    /**
     * 加入时间
     */
    @Column(name = "join_time")
    private Long joinTime;

    /**
     * 管理员确认报名状态
     */
    @Column(name = "singed_course")
    private Boolean singedCourse;

    private static final long serialVersionUID = 1L;

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return event_id
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * @param eventId
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    /**
     * 获取签到时间
     *
     * @return check_in_time - 签到时间
     */
    public Long getCheckInTime() {
        return checkInTime;
    }

    /**
     * 设置签到时间
     *
     * @param checkInTime 签到时间
     */
    public void setCheckInTime(Long checkInTime) {
        this.checkInTime = checkInTime;
    }

    /**
     * 获取签退时间
     *
     * @return check_out_time - 签退时间
     */
    public Long getCheckOutTime() {
        return checkOutTime;
    }

    /**
     * 设置签退时间
     *
     * @param checkOutTime 签退时间
     */
    public void setCheckOutTime(Long checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    /**
     * 获取是否出席
     *
     * @return is_attendance - 是否出席
     */
    public Boolean getIsAttendance() {
        return isAttendance;
    }

    /**
     * 设置是否出席
     *
     * @param isAttendance 是否出席
     */
    public void setIsAttendance(Boolean isAttendance) {
        this.isAttendance = isAttendance;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取代出席人
     *
     * @return agent - 代出席人
     */
    public String getAgent() {
        return agent;
    }

    /**
     * 设置代出席人
     *
     * @param agent 代出席人
     */
    public void setAgent(String agent) {
        this.agent = agent;
    }

    /**
     * 获取代出席人岗位
     *
     * @return agent_role - 代出席人岗位
     */
    public String getAgentRole() {
        return agentRole;
    }

    /**
     * 设置代出席人岗位
     *
     * @param agentRole 代出席人岗位
     */
    public void setAgentRole(String agentRole) {
        this.agentRole = agentRole;
    }

    /**
     * 获取缺席原因
     *
     * @return absent_reason - 缺席原因
     */
    public String getAbsentReason() {
        return absentReason;
    }

    /**
     * 设置缺席原因
     *
     * @param absentReason 缺席原因
     */
    public void setAbsentReason(String absentReason) {
        this.absentReason = absentReason;
    }

    /**
     * 获取是否留言
     *
     * @return facebook_comment - 是否留言
     */
    public Boolean getFacebookComment() {
        return facebookComment;
    }

    /**
     * 设置是否留言
     *
     * @param facebookComment 是否留言
     */
    public void setFacebookComment(Boolean facebookComment) {
        this.facebookComment = facebookComment;
    }

    /**
     * 获取加入时间
     *
     * @return join_time - 加入时间
     */
    public Long getJoinTime() {
        return joinTime;
    }

    /**
     * 设置加入时间
     *
     * @param joinTime 加入时间
     */
    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }

    /**
     * 获取管理员确认报名状态
     *
     * @return singed_course - 管理员确认报名状态
     */
    public Boolean getSingedCourse() {
        return singedCourse;
    }

    /**
     * 设置管理员确认报名状态
     *
     * @param singedCourse 管理员确认报名状态
     */
    public void setSingedCourse(Boolean singedCourse) {
        this.singedCourse = singedCourse;
    }
}