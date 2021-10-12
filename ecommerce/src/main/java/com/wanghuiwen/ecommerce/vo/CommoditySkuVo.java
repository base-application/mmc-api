package com.wanghuiwen.ecommerce.vo;

import java.math.BigDecimal;
import java.util.List;

public class CommoditySkuVo {
    private Long specsId;

    private Long commodityId;

    private String specsName;

    private String specsImage;

    private String specsStock;

    private BigDecimal specsPrice;

    private String specsAttr;

    private BigDecimal costPrice;

    private Double weight;

    List<SkuAttributeValue> skuAttributeValue;


    public Long getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Long specsId) {
        this.specsId = specsId;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public String getSpecsName() {
        return specsName;
    }

    public void setSpecsName(String specsName) {
        this.specsName = specsName;
    }

    public String getSpecsImage() {
        return specsImage;
    }

    public void setSpecsImage(String specsImage) {
        this.specsImage = specsImage;
    }

    public String getSpecsStock() {
        return specsStock;
    }

    public void setSpecsStock(String specsStock) {
        this.specsStock = specsStock;
    }

    public BigDecimal getSpecsPrice() {
        return specsPrice;
    }

    public void setSpecsPrice(BigDecimal specsPrice) {
        this.specsPrice = specsPrice;
    }

    public String getSpecsAttr() {
        return specsAttr;
    }

    public void setSpecsAttr(String specsAttr) {
        this.specsAttr = specsAttr;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public List<SkuAttributeValue> getSkuAttributeValue() {
        return skuAttributeValue;
    }

    public void setSkuAttributeValue(List<SkuAttributeValue> skuAttributeValue) {
        this.skuAttributeValue = skuAttributeValue;
    }
}
