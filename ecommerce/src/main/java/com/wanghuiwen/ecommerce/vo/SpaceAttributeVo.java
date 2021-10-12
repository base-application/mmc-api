package com.wanghuiwen.ecommerce.vo;


import com.wanghuiwen.ecommerce.model.SpecsValue;

import java.util.List;

/**
 * 规格属性
 */
public class SpaceAttributeVo {

    private Long attributeId;

    private String attributeName;

    private Long commodityId;

    List<SpecsValue> value;

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public List<SpecsValue> getValue() {
        return value;
    }

    public void setValue(List<SpecsValue> value) {
        this.value = value;
    }
}
