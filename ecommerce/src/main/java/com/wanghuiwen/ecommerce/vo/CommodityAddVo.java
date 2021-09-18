package com.wanghuiwen.ecommerce.vo;

import com.wanghuiwen.ecommerce.model.CommoditySlide;

import java.util.List;

public class CommodityAddVo {

    private Long commodityId;

    private String commodityName;

    private Long categoryId;

    private Long carriageTemplateId;

    private Integer state;

    private Integer commodityType;

    private Long merchantCategoryId;

    private Byte stockMode;

    private List<CommoditySlide> slide;

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCarriageTemplateId() {
        return carriageTemplateId;
    }

    public void setCarriageTemplateId(Long carriageTemplateId) {
        this.carriageTemplateId = carriageTemplateId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(Integer commodityType) {
        this.commodityType = commodityType;
    }

    public Long getMerchantCategoryId() {
        return merchantCategoryId;
    }

    public void setMerchantCategoryId(Long merchantCategoryId) {
        this.merchantCategoryId = merchantCategoryId;
    }

    public Byte getStockMode() {
        return stockMode;
    }

    public void setStockMode(Byte stockMode) {
        this.stockMode = stockMode;
    }

    public List<CommoditySlide> getSlide() {
        return slide;
    }

    public void setSlide(List<CommoditySlide> slide) {
        this.slide = slide;
    }
}
