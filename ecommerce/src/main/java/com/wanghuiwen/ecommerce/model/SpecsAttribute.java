package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "specs_attribute")
public class SpecsAttribute implements Serializable {
    @Id
    @Column(name = "attribute_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attributeId;

    /**
     * 属性名
     */
    @Column(name = "attribute_name")
    private String attributeName;

    /**
     * 商品Id
     */
    @Column(name = "commodity_id")
    private Long commodityId;

    private static final long serialVersionUID = 1L;

    /**
     * @return attribute_id
     */
    public Long getAttributeId() {
        return attributeId;
    }

    /**
     * @param attributeId
     */
    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * 获取属性名
     *
     * @return attribute_name - 属性名
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * 设置属性名
     *
     * @param attributeName 属性名
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
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
}