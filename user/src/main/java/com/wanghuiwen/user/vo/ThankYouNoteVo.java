package com.wanghuiwen.user.vo;

import java.util.List;

public class ThankYouNoteVo {

    /**
     * fromUserId : 1
     * fromPicture : 头像
     * fromGroupId : 1
     * fromName : 名称
     * toUserId : 1
     * toPicture : 头像
     * toGroupId : 1
     * toName : 名称
     * thankYouNoteId : 1
     * sendUser : 1
     * receivedUser : 1
     * sendTime : 1
     * receivedTime : 1
     * note : 感谢内容
     * value : 1
     */

    private Long fromUserId;
    private String fromPicture;
    private int fromGroupId;
    private String fromName;
    private Long toUserId;
    private String toPicture;
    private int toGroupId;
    private String toName;
    private Long thankYouNoteId;
    private Long sendUser;
    private Long receivedUser;
    private Long sendTime;
    private Long receivedTime;
    private String note;
    private int value;
    private String fromGroup;
    private String toGroup;
    private List<ImageVo> picture;

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromPicture() {
        return fromPicture;
    }

    public void setFromPicture(String fromPicture) {
        this.fromPicture = fromPicture;
    }

    public int getFromGroupId() {
        return fromGroupId;
    }

    public void setFromGroupId(int fromGroupId) {
        this.fromGroupId = fromGroupId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public String getToPicture() {
        return toPicture;
    }

    public void setToPicture(String toPicture) {
        this.toPicture = toPicture;
    }

    public int getToGroupId() {
        return toGroupId;
    }

    public void setToGroupId(int toGroupId) {
        this.toGroupId = toGroupId;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public Long getThankYouNoteId() {
        return thankYouNoteId;
    }

    public void setThankYouNoteId(Long thankYouNoteId) {
        this.thankYouNoteId = thankYouNoteId;
    }

    public Long getSendUser() {
        return sendUser;
    }

    public void setSendUser(Long sendUser) {
        this.sendUser = sendUser;
    }

    public Long getReceivedUser() {
        return receivedUser;
    }

    public void setReceivedUser(Long receivedUser) {
        this.receivedUser = receivedUser;
    }

    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }

    public Long getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Long receivedTime) {
        this.receivedTime = receivedTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<ImageVo> getPicture() {
        return picture;
    }

    public void setPicture(List<ImageVo> picture) {
        this.picture = picture;
    }

    public String getFromGroup() {
        return fromGroup;
    }

    public void setFromGroup(String fromGroup) {
        this.fromGroup = fromGroup;
    }

    public String getToGroup() {
        return toGroup;
    }

    public void setToGroup(String toGroup) {
        this.toGroup = toGroup;
    }
}
