package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "notification_grade")
public class NotificationGrade implements Serializable {
    @Id
    @Column(name = "notification_id")
    private Long notificationId;

    @Column(name = "grade_id")
    private Integer gradeId;

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
     * @return grade_id
     */
    public Integer getGradeId() {
        return gradeId;
    }

    /**
     * @param gradeId
     */
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }
}