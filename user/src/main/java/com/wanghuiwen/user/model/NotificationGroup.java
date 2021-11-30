package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "notification_group")
public class NotificationGroup implements Serializable {
    @Id
    @Column(name = "notification_id")
    private Long notificationId;

    @Column(name = "group_id")
    private Integer groupId;

    private static final long serialVersionUID = 1L;

    /**
     * @return notification_id
     */
    public Long getNotificationId() {
        return notificationId;
    }

    /**
     * @param notificationId
     */
    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * @return group_id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}