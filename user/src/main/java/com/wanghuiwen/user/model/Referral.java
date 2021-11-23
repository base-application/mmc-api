package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

public class Referral implements Serializable {
    @Id
    @Column(name = "referral_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long referralId;

    private String reason;

    /**
     * 接收用户
     */
    @Column(name = "received_user")
    private Long receivedUser;

    /**
     * 发送用户
     */
    @Column(name = "send_user")
    private Long sendUser;

    /**
     * 失败原因
     */
    @Column(name = "fail_message")
    private String failMessage;

    /**
     * 发送时间
     */
    @Column(name = "send_time")
    private Long sendTime;

    /**
     * 接收时间
     */
    @Column(name = "received_time")
    private Long receivedTime;

    /**
     * 状态 1发送 2 接收成功 3 接收失败
     */
    private Integer status;

    /**
     *  备注
     */
    private String remark;

    /**
     * 是否发送thank you
     */
    private Boolean thank;

    private static final long serialVersionUID = 1L;

    /**
     * @return referral_id
     */
    public Long getReferralId() {
        return referralId;
    }

    /**
     * @param referralId
     */
    public void setReferralId(Long referralId) {
        this.referralId = referralId;
    }

    /**
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取接收用户
     *
     * @return received_user - 接收用户
     */
    public Long getReceivedUser() {
        return receivedUser;
    }

    /**
     * 设置接收用户
     *
     * @param receivedUser 接收用户
     */
    public void setReceivedUser(Long receivedUser) {
        this.receivedUser = receivedUser;
    }

    /**
     * 获取发送用户
     *
     * @return send_user - 发送用户
     */
    public Long getSendUser() {
        return sendUser;
    }

    /**
     * 设置发送用户
     *
     * @param sendUser 发送用户
     */
    public void setSendUser(Long sendUser) {
        this.sendUser = sendUser;
    }

    /**
     * 获取失败原因
     *
     * @return fail_message - 失败原因
     */
    public String getFailMessage() {
        return failMessage;
    }

    /**
     * 设置失败原因
     *
     * @param failMessage 失败原因
     */
    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    /**
     * 获取发送时间
     *
     * @return send_time - 发送时间
     */
    public Long getSendTime() {
        return sendTime;
    }

    /**
     * 设置发送时间
     *
     * @param sendTime 发送时间
     */
    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取接收时间
     *
     * @return received_time - 接收时间
     */
    public Long getReceivedTime() {
        return receivedTime;
    }

    /**
     * 设置接收时间
     *
     * @param receivedTime 接收时间
     */
    public void setReceivedTime(Long receivedTime) {
        this.receivedTime = receivedTime;
    }

    /**
     * 获取状态 1发送 2 接收成功 3 接收失败
     *
     * @return status - 状态 1发送 2 接收成功 3 接收失败
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 1发送 2 接收成功 3 接收失败
     *
     * @param status 状态 1发送 2 接收成功 3 接收失败
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取 备注
     *
     * @return remark -  备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注
     *
     * @param remark  备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取是否发送thank you
     *
     * @return thank - 是否发送thank you
     */
    public Boolean getThank() {
        return thank;
    }

    /**
     * 设置是否发送thank you
     *
     * @param thank 是否发送thank you
     */
    public void setThank(Boolean thank) {
        this.thank = thank;
    }
}