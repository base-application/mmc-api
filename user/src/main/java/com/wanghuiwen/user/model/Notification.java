package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

public class Notification implements Serializable {
    @Id
    @Column(name = "notification_id")
    private Integer notificationId;

    /**
     * 通知标题
     */
    @Column(name = "notification_title")
    private String notificationTitle;

    /**
     * 按钮名称
     */
    @Column(name = "registration_name")
    private String registrationName;

    /**
     * 按钮连接
     */
    @Column(name = "registration_link")
    private String registrationLink;

    /**
     * 创建人
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 时间
     */
    @Column(name = "notification_time")
    private Long notificationTime;

    /**
     * 有5种选项 - Loan genie, Property deal, News, Updates, System
     */
    @Column(name = "notification_type")
    private Integer notificationType;

    /**
     * 链接数据ID
     */
    @Column(name = "link_id")
    private String linkId;

    /**
     * 1event 2 refferral
     */
    @Column(name = "link_type")
    private Integer linkType;

    /**
     * 通知内容
     */
    @Column(name = "notification_content")
    private String notificationContent;

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
     * 获取通知标题
     *
     * @return notification_title - 通知标题
     */
    public String getNotificationTitle() {
        return notificationTitle;
    }

    /**
     * 设置通知标题
     *
     * @param notificationTitle 通知标题
     */
    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    /**
     * 获取按钮名称
     *
     * @return registration_name - 按钮名称
     */
    public String getRegistrationName() {
        return registrationName;
    }

    /**
     * 设置按钮名称
     *
     * @param registrationName 按钮名称
     */
    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    /**
     * 获取按钮连接
     *
     * @return registration_link - 按钮连接
     */
    public String getRegistrationLink() {
        return registrationLink;
    }

    /**
     * 设置按钮连接
     *
     * @param registrationLink 按钮连接
     */
    public void setRegistrationLink(String registrationLink) {
        this.registrationLink = registrationLink;
    }

    /**
     * 获取创建人
     *
     * @return create_id - 创建人
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置创建人
     *
     * @param createId 创建人
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取时间
     *
     * @return notification_time - 时间
     */
    public Long getNotificationTime() {
        return notificationTime;
    }

    /**
     * 设置时间
     *
     * @param notificationTime 时间
     */
    public void setNotificationTime(Long notificationTime) {
        this.notificationTime = notificationTime;
    }

    /**
     * 获取有5种选项 - Loan genie, Property deal, News, Updates, System
     *
     * @return notification_type - 有5种选项 - Loan genie, Property deal, News, Updates, System
     */
    public Integer getNotificationType() {
        return notificationType;
    }

    /**
     * 设置有5种选项 - Loan genie, Property deal, News, Updates, System
     *
     * @param notificationType 有5种选项 - Loan genie, Property deal, News, Updates, System
     */
    public void setNotificationType(Integer notificationType) {
        this.notificationType = notificationType;
    }

    /**
     * 获取链接数据ID
     *
     * @return link_id - 链接数据ID
     */
    public String getLinkId() {
        return linkId;
    }

    /**
     * 设置链接数据ID
     *
     * @param linkId 链接数据ID
     */
    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    /**
     * 获取1event 2 refferral
     *
     * @return link_type - 1event 2 refferral
     */
    public Integer getLinkType() {
        return linkType;
    }

    /**
     * 设置1event 2 refferral
     *
     * @param linkType 1event 2 refferral
     */
    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    /**
     * 获取通知内容
     *
     * @return notification_content - 通知内容
     */
    public String getNotificationContent() {
        return notificationContent;
    }

    /**
     * 设置通知内容
     *
     * @param notificationContent 通知内容
     */
    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }
}