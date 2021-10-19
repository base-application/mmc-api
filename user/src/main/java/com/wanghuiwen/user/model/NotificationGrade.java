package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "notification_grade")
public class NotificationGrade implements Serializable {
    @Id
    @Column(name = "notification_id")
    private Integer notificationId;

    @Column(name = "grade_id")
    private Integer gradeId;

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