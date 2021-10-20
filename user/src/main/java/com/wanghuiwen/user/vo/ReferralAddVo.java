package com.wanghuiwen.user.vo;

import java.util.List;

public class ReferralAddVo {


    /**
     * reason :
     * receivedUser : 1
     */

    private String reason;
    private Long receivedUser;
    private List<ImageVo> picture;

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

    public List<ImageVo> getPicture() {
        return picture;
    }

    public void setPicture(List<ImageVo> picture) {
        this.picture = picture;
    }
}
