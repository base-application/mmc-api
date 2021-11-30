package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "check_log")
public class CheckLog implements Serializable {
    @Id
    @Column(name = "check_log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkLogId;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "check_type")
    private Integer checkType;

    @Column(name = "create_time")
    private Long createTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return check_log_id
     */
    public Long getCheckLogId() {
        return checkLogId;
    }

    /**
     * @param checkLogId
     */
    public void setCheckLogId(Long checkLogId) {
        this.checkLogId = checkLogId;
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
     * @return check_type
     */
    public Integer getCheckType() {
        return checkType;
    }

    /**
     * @param checkType
     */
    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    /**
     * @return create_time
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}