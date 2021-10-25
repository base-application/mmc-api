package com.wanghuiwen.user.vo;

import java.util.List;

public class ReferralVo {

    /**
     * fromUserId : 1
     * fromPicture : 头像
     * fromGroupId : 1
     * fromName : 名称
     * toUserId : 1
     * toPicture : 头像
     * toGroupId : 1
     * toName : 名称
     * referralId : 1
     * reason :
     * receivedUser : 1
     * sendUser : 1
     * failMessage : 失败原因
     * sendTime : 123
     * receivedTime : 123
     * status : 1
     * remark : remark
     */

    private String fromPicture;
    private int fromGroupId;
    private String fromName;
    private String fromGroup;
    private String toPicture;
    private int toGroupId;
    private String toGroup;
    private String toName;
    private Long referralId;
    private String reason;
    private Long receivedUser;
    private Long sendUser;
    private String failMessage;
    private Long sendTime;
    private Long receivedTime;
    private int status;
    private String remark;
    private List<ImageVo> picture;
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

    public Long getReferralId() {
        return referralId;
    }

    public void setReferralId(Long referralId) {
        this.referralId = referralId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getReceivedUser() {
        return receivedUser;
    }

    public void setReceivedUser(Long receivedUser) {
        this.receivedUser = receivedUser;
    }

    public Long getSendUser() {
        return sendUser;
    }

    public void setSendUser(Long sendUser) {
        this.sendUser = sendUser;
    }

    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
