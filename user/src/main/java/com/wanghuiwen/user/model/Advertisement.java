package com.wanghuiwen.user.model;

import java.io.Serializable;
import javax.persistence.*;

public class Advertisement implements Serializable {
    @Column(name = "advertisement_id")
    private Integer advertisementId;

    /**
     * 封面
     */
    @Column(name = "advertisement_poster")
    private String advertisementPoster;

    /**
     * 类型
     */
    @Column(name = "advertisement_type")
    private Integer advertisementType;

    /**
     * 是否发布
     */
    private Boolean status;

    /**
     * 外链
     */
    @Column(name = "advertisement_link")
    private String advertisementLink;

    private static final long serialVersionUID = 1L;

    /**
     * @return advertisement_id
     */
    public Integer getAdvertisementId() {
        return advertisementId;
    }

    /**
     * @param advertisementId
     */
    public void setAdvertisementId(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    /**
     * 获取封面
     *
     * @return advertisement_poster - 封面
     */
    public String getAdvertisementPoster() {
        return advertisementPoster;
    }

    /**
     * 设置封面
     *
     * @param advertisementPoster 封面
     */
    public void setAdvertisementPoster(String advertisementPoster) {
        this.advertisementPoster = advertisementPoster;
    }

    /**
     * 获取类型
     *
     * @return advertisement_type - 类型
     */
    public Integer getAdvertisementType() {
        return advertisementType;
    }

    /**
     * 设置类型
     *
     * @param advertisementType 类型
     */
    public void setAdvertisementType(Integer advertisementType) {
        this.advertisementType = advertisementType;
    }

    /**
     * 获取是否发布
     *
     * @return status - 是否发布
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置是否发布
     *
     * @param status 是否发布
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取外链
     *
     * @return advertisement_link - 外链
     */
    public String getAdvertisementLink() {
        return advertisementLink;
    }

    /**
     * 设置外链
     *
     * @param advertisementLink 外链
     */
    public void setAdvertisementLink(String advertisementLink) {
        this.advertisementLink = advertisementLink;
    }
}