package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "commodity_service")
public class CommodityService implements Serializable {
    @Id
    @Column(name = "commodity_service_id")
    private Long commodityServiceId;

    /**
     * 商品Id
     */
    @Column(name = "commodity_id")
    private Long commodityId;

    /**
     * 服务Id
     */
    @Column(name = "merchant_service_id")
    private Integer merchantServiceId;

    private static final long serialVersionUID = 1L;

    /**
     * @return commodity_service_id
     */
    public Long getCommodityServiceId() {
        return commodityServiceId;
    }

    /**
     * @param commodityServiceId
     */
    public void setCommodityServiceId(Long commodityServiceId) {
        this.commodityServiceId = commodityServiceId;
    }

    /**
     * 获取商品Id
     *
     * @return commodity_id - 商品Id
     */
    public Long getCommodityId() {
        return commodityId;
    }

    /**
     * 设置商品Id
     *
     * @param commodityId 商品Id
     */
    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * 获取服务Id
     *
     * @return merchant_service_id - 服务Id
     */
    public Integer getMerchantServiceId() {
        return merchantServiceId;
    }

    /**
     * 设置服务Id
     *
     * @param merchantServiceId 服务Id
     */
    public void setMerchantServiceId(Integer merchantServiceId) {
        this.merchantServiceId = merchantServiceId;
    }
}