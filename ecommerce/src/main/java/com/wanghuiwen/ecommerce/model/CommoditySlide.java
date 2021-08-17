package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "commodity_slide")
public class CommoditySlide implements Serializable {
    @Id
    @Column(name = "commodity_id")
    private Long commodityId;

    /**
     * 资源路径/视频资源这里是封面
     */
    @Column(name = "resource_url")
    private Long resourceUrl;

    /**
     * 1图片 2 视频
     */
    @Column(name = "resource_type")
    private Long resourceType;

    /**
     * 视频路径
     */
    @Column(name = "video_url")
    private String videoUrl;

    private static final long serialVersionUID = 1L;

    /**
     * @return commodity_id
     */
    public Long getCommodityId() {
        return commodityId;
    }

    /**
     * @param commodityId
     */
    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * 获取资源路径/视频资源这里是封面
     *
     * @return resource_url - 资源路径/视频资源这里是封面
     */
    public Long getResourceUrl() {
        return resourceUrl;
    }

    /**
     * 设置资源路径/视频资源这里是封面
     *
     * @param resourceUrl 资源路径/视频资源这里是封面
     */
    public void setResourceUrl(Long resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
     * 获取1图片 2 视频
     *
     * @return resource_type - 1图片 2 视频
     */
    public Long getResourceType() {
        return resourceType;
    }

    /**
     * 设置1图片 2 视频
     *
     * @param resourceType 1图片 2 视频
     */
    public void setResourceType(Long resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 获取视频路径
     *
     * @return video_url - 视频路径
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置视频路径
     *
     * @param videoUrl 视频路径
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}