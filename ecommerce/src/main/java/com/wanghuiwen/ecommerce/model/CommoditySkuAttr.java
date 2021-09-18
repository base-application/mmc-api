package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "commodity_sku_attr")
public class CommoditySkuAttr implements Serializable {
    @Id
    @Column(name = "commodity_sku_id")
    private Long commoditySkuId;

    @Column(name = "specs_attribute_id")
    private Long specsAttributeId;

    @Column(name = "specs_value_id")
    private Long specsValueId;

    private static final long serialVersionUID = 1L;

    /**
     * @return commodity_sku_id
     */
    public Long getCommoditySkuId() {
        return commoditySkuId;
    }

    /**
     * @param commoditySkuId
     */
    public void setCommoditySkuId(Long commoditySkuId) {
        this.commoditySkuId = commoditySkuId;
    }

    /**
     * @return specs_attribute_id
     */
    public Long getSpecsAttributeId() {
        return specsAttributeId;
    }

    /**
     * @param specsAttributeId
     */
    public void setSpecsAttributeId(Long specsAttributeId) {
        this.specsAttributeId = specsAttributeId;
    }

    /**
     * @return specs_value_id
     */
    public Long getSpecsValueId() {
        return specsValueId;
    }

    /**
     * @param specsValueId
     */
    public void setSpecsValueId(Long specsValueId) {
        this.specsValueId = specsValueId;
    }
}