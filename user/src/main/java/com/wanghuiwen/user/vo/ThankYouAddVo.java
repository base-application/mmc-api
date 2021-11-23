package com.wanghuiwen.user.vo;

import java.util.List;

public class ThankYouAddVo {

    /**
     * thankYouNoteId : 1
     * receivedUser : 1
     * note : 感谢内容
     * value : 1
     * referralId : 1
     */

    private Long thankYouNoteId;
    private Long receivedUser;
    private Long sender;
    private String note;
    private double value;
    private Long referralId;
    private List<ImageVo> picture;

    public Long getThankYouNoteId() {
        return thankYouNoteId;
    }

    public void setThankYouNoteId(Long thankYouNoteId) {
        this.thankYouNoteId = thankYouNoteId;
    }

    public Long getReceivedUser() {
        return receivedUser;
    }

    public void setReceivedUser(Long receivedUser) {
        this.receivedUser = receivedUser;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Long getReferralId() {
        return referralId;
    }

    public void setReferralId(Long referralId) {
        this.referralId = referralId;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public List<ImageVo> getPicture() {
        return picture;
    }

    public void setPicture(List<ImageVo> picture) {
        this.picture = picture;
    }
}
