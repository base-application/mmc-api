package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "notification_user")
public class NotificationUser implements Serializable {
    @Id
    @Column(name = "notification_id")
    private Integer notificationId;

    @Column(name = "user_id")
    private Long userId;

    /**
     * 1已读 2 删除
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    /**
     * @return notification_id
     */
    public Integer getNotificationId() {
        return notificationId;
    }

    /**
     * @param notificationId
     */
    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
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
     * 获取1已读 2 删除
     *
     * @return status - 1已读 2 删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1已读 2 删除
     *
     * @param status 1已读 2 删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}