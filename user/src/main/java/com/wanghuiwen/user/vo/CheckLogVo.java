package com.wanghuiwen.user.vo;


public class CheckLogVo {
    private Long checkLogId;

    private Long eventId;

    private Long userId;

    private Integer checkType;

    private Long createTime;

    private String eventTitle;

    public Long getCheckLogId() {
        return checkLogId;
    }

    public void setCheckLogId(Long checkLogId) {
        this.checkLogId = checkLogId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
}
