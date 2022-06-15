package com.wanghuiwen.user.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "mmc_event")
public class MmcEvent implements Serializable {
    @Id
    @Column(name = "event_id")
    private Long eventId;

    /**
     * 活动标题
     */
    @Column(name = "event_title")
    private String eventTitle;

    /**
     * 活动介绍
     */
    @Column(name = "event_description")
    private String eventDescription;

    /**
     * 开始时间
     */
    @Column(name = "event_start_time")
    private Long eventStartTime;

    /**
     * 结束时间
     */
    @Column(name = "event_end_time")
    private Long eventEndTime;

    /**
     * 活动位置
     */
    @Column(name = "event_location")
    private String eventLocation;

    /**
     * 地图连接
     */
    @Column(name = "event_map_link")
    private String eventMapLink;

    @Column(name = "event_type")
    private String eventType;

    /**
     * 创建人
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 审核状态 1 未处理 2 同意 3 拒绝
     */
    @Column(name = "approve_status")
    private Integer approveStatus;

    /**
     * 是否删除
     */
    private Boolean del;

    /**
     * 分享积分
     */
    private BigDecimal point;

    /**
     * 封面
     */
    private String thumbnail;

    private static final long serialVersionUID = 1L;

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
     * 获取活动标题
     *
     * @return event_title - 活动标题
     */
    public String getEventTitle() {
        return eventTitle;
    }

    /**
     * 设置活动标题
     *
     * @param eventTitle 活动标题
     */
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    /**
     * 获取活动介绍
     *
     * @return event_description - 活动介绍
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * 设置活动介绍
     *
     * @param eventDescription 活动介绍
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    /**
     * 获取开始时间
     *
     * @return event_start_time - 开始时间
     */
    public Long getEventStartTime() {
        return eventStartTime;
    }

    /**
     * 设置开始时间
     *
     * @param eventStartTime 开始时间
     */
    public void setEventStartTime(Long eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    /**
     * 获取结束时间
     *
     * @return event_end_time - 结束时间
     */
    public Long getEventEndTime() {
        return eventEndTime;
    }

    /**
     * 设置结束时间
     *
     * @param eventEndTime 结束时间
     */
    public void setEventEndTime(Long eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    /**
     * 获取活动位置
     *
     * @return event_location - 活动位置
     */
    public String getEventLocation() {
        return eventLocation;
    }

    /**
     * 设置活动位置
     *
     * @param eventLocation 活动位置
     */
    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    /**
     * 获取地图连接
     *
     * @return event_map_link - 地图连接
     */
    public String getEventMapLink() {
        return eventMapLink;
    }

    /**
     * 设置地图连接
     *
     * @param eventMapLink 地图连接
     */
    public void setEventMapLink(String eventMapLink) {
        this.eventMapLink = eventMapLink;
    }

    /**
     * @return event_type
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @param eventType
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
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
     * 获取审核状态 1 未处理 2 同意 3 拒绝
     *
     * @return approve_status - 审核状态 1 未处理 2 同意 3 拒绝
     */
    public Integer getApproveStatus() {
        return approveStatus;
    }

    /**
     * 设置审核状态 1 未处理 2 同意 3 拒绝
     *
     * @param approveStatus 审核状态 1 未处理 2 同意 3 拒绝
     */
    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    /**
     * 获取是否删除
     *
     * @return del - 是否删除
     */
    public Boolean getDel() {
        return del;
    }

    /**
     * 设置是否删除
     *
     * @param del 是否删除
     */
    public void setDel(Boolean del) {
        this.del = del;
    }

    /**
     * 获取分享积分
     *
     * @return point - 分享积分
     */
    public BigDecimal getPoint() {
        return point;
    }

    /**
     * 设置分享积分
     *
     * @param point 分享积分
     */
    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    /**
     * 获取封面
     *
     * @return thumbnail - 封面
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 设置封面
     *
     * @param thumbnail 封面
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}