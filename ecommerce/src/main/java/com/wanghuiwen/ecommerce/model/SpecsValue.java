package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "specs_value")
public class SpecsValue implements Serializable {
    @Id
    @Column(name = "attribute_value_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attributeValueId;

    @Column(name = "attribute_id")
    private Long attributeId;

    @Column(name = "attribute_value")
    private String attributeValue;

    private static final long serialVersionUID = 1L;

    /**
     * @return attribute_value_id
     */
    public Long getAttributeValueId() {
        return attributeValueId;
    }

    /**
     * @param attributeValueId
     */
    public void setAttributeValueId(Long attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

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
     * @return attribute_value
     */
    public String getAttributeValue() {
        return attributeValue;
    }

    /**
     * @param attributeValue
     */
    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}