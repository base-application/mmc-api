package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "merchant_service")
public class MerchantService implements Serializable {
    @Id
    @Column(name = "service_id")
    private Integer serviceId;

    /**
     * 服务标题
     */
    @Column(name = "service_title")
    private String serviceTitle;

    /**
     * 服务内容
     */
    @Column(name = "service_detail")
    private String serviceDetail;

    @Column(name = "merchant_id")
    private Long merchantId;

    /**
     * 是否删除
     */
    private Boolean available;

    private static final long serialVersionUID = 1L;

    /**
     * @return service_id
     */
    public Integer getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId
     */
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * 获取服务标题
     *
     * @return service_title - 服务标题
     */
    public String getServiceTitle() {
        return serviceTitle;
    }

    /**
     * 设置服务标题
     *
     * @param serviceTitle 服务标题
     */
    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    /**
     * 获取服务内容
     *
     * @return service_detail - 服务内容
     */
    public String getServiceDetail() {
        return serviceDetail;
    }

    /**
     * 设置服务内容
     *
     * @param serviceDetail 服务内容
     */
    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    /**
     * @return merchant_id
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取是否删除
     *
     * @return available - 是否删除
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * 设置是否删除
     *
     * @param available 是否删除
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }
}