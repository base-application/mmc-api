package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "referral_picture")
public class ReferralPicture implements Serializable {
    @Id
    @Column(name = "picture_id")
    private Long pictureId;

    @Column(name = "referral_id")
    private Long referralId;

    private String url;

    private static final long serialVersionUID = 1L;

    /**
     * @return picture_id
     */
    public Long getPictureId() {
        return pictureId;
    }

    /**
     * @param pictureId
     */
    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}