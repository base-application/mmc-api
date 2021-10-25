package com.wanghuiwen.user.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "thank_you_note")
public class ThankYouNote implements Serializable {
    @Id
    @Column(name = "thank_you_note_id")
    private Long thankYouNoteId;

    /**
     * 发送人
     */
    @Column(name = "send_user")
    private Long sendUser;

    /**
     * 接收人
     */
    @Column(name = "received_user")
    private Long receivedUser;

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
     * 感谢内容
     */
    private String note;

    /**
     * 感谢金额
     */
    private BigDecimal value;

    /**
     * 关联refrral
     */
    @Column(name = "referral_id")
    private Long referralId;

    private static final long serialVersionUID = 1L;

    /**
     * @return thank_you_note_id
     */
    public Long getThankYouNoteId() {
        return thankYouNoteId;
    }

    /**
     * @param thankYouNoteId
     */
    public void setThankYouNoteId(Long thankYouNoteId) {
        this.thankYouNoteId = thankYouNoteId;
    }

    /**
     * 获取发送人
     *
     * @return send_user - 发送人
     */
    public Long getSendUser() {
        return sendUser;
    }

    /**
     * 设置发送人
     *
     * @param sendUser 发送人
     */
    public void setSendUser(Long sendUser) {
        this.sendUser = sendUser;
    }

    /**
     * 获取接收人
     *
     * @return received_user - 接收人
     */
    public Long getReceivedUser() {
        return receivedUser;
    }

    /**
     * 设置接收人
     *
     * @param receivedUser 接收人
     */
    public void setReceivedUser(Long receivedUser) {
        this.receivedUser = receivedUser;
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
     * 获取感谢内容
     *
     * @return note - 感谢内容
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置感谢内容
     *
     * @param note 感谢内容
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取感谢金额
     *
     * @return value - 感谢金额
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * 设置感谢金额
     *
     * @param value 感谢金额
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * 获取关联refrral
     *
     * @return referral_id - 关联refrral
     */
    public Long getReferralId() {
        return referralId;
    }

    /**
     * 设置关联refrral
     *
     * @param referralId 关联refrral
     */
    public void setReferralId(Long referralId) {
        this.referralId = referralId;
    }
}