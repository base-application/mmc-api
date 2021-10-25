package com.wanghuiwen.user.vo;

import com.wanghuiwen.user.model.Grade;
import com.wanghuiwen.user.model.MmcGroup;

import java.util.List;

public class NotificationVo {
    private Integer notificationId;

    private String notificationTitle;

    private String registrationName;

    private String registrationLink;

    private Long createId;

    private Long notificationTime;

    /**
     * 有5种选项 - Loan genie, Property deal, News, Updates, System
     */
    private Integer notificationType;
    private String notificationContent;

    List<Grade> grades;
    List<MmcGroup> groups;

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(String registrationLink) {
        this.registrationLink = registrationLink;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(Long notificationTime) {
        this.notificationTime = notificationTime;
    }

    public Integer getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(Integer notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<MmcGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<MmcGroup> groups) {
        this.groups = groups;
    }
}
