package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

public class Commodity implements Serializable {
    @Id
    @Column(name = "commodity_id")
    private Long commodityId;

    /**
     * 商品名称
     */
    @Column(name = "commodity_name")
    private String commodityName;

    /**
     * 商品分类
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 是否包邮
     */
    @Column(name = "free_postage")
    private Boolean freePostage;

    /**
     * 统一运费
     */
    private BigDecimal postage;

    /**
     * 包邮设置
     */
    @Column(name = "free_postage_condition")
    private Long freePostageCondition;

    /**
     * 运费模版
     */
    @Column(name = "carriage_template_id")
    private Long carriageTemplateId;

    /**
     * 几件起购
     */
    @Column(name = "min_purchase")
    private Integer minPurchase;

    /**
     * 商品状态 1 发布 2 不发布
     */
    private Integer state;

    /**
     * 限购数量
     */
    @Column(name = "user_limit")
    private Integer userLimit;

    /**
     * 1 每天 2 每周 3 每年 4 永久
     */
    @Column(name = "limit_mode")
    private Integer limitMode;

    /**
     * 商品类型 1 实物 2 虚拟
     */
    @Column(name = "commodity_type")
    private Integer commodityType;

    /**
     * 商品店铺分类
     */
    @Column(name = "merchant_category_id")
    private Long merchantCategoryId;

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
     * 获取商品名称
     *
     * @return commodity_name - 商品名称
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * 设置商品名称
     *
     * @param commodityName 商品名称
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    /**
     * 获取商品分类
     *
     * @return category_id - 商品分类
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品分类
     *
     * @param categoryId 商品分类
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取是否包邮
     *
     * @return free_postage - 是否包邮
     */
    public Boolean getFreePostage() {
        return freePostage;
    }

    /**
     * 设置是否包邮
     *
     * @param freePostage 是否包邮
     */
    public void setFreePostage(Boolean freePostage) {
        this.freePostage = freePostage;
    }

    /**
     * 获取统一运费
     *
     * @return postage - 统一运费
     */
    public BigDecimal getPostage() {
        return postage;
    }

    /**
     * 设置统一运费
     *
     * @param postage 统一运费
     */
    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    /**
     * 获取包邮设置
     *
     * @return free_postage_condition - 包邮设置
     */
    public Long getFreePostageCondition() {
        return freePostageCondition;
    }

    /**
     * 设置包邮设置
     *
     * @param freePostageCondition 包邮设置
     */
    public void setFreePostageCondition(Long freePostageCondition) {
        this.freePostageCondition = freePostageCondition;
    }

    /**
     * 获取运费模版
     *
     * @return carriage_template_id - 运费模版
     */
    public Long getCarriageTemplateId() {
        return carriageTemplateId;
    }

    /**
     * 设置运费模版
     *
     * @param carriageTemplateId 运费模版
     */
    public void setCarriageTemplateId(Long carriageTemplateId) {
        this.carriageTemplateId = carriageTemplateId;
    }

    /**
     * 获取几件起购
     *
     * @return min_purchase - 几件起购
     */
    public Integer getMinPurchase() {
        return minPurchase;
    }

    /**
     * 设置几件起购
     *
     * @param minPurchase 几件起购
     */
    public void setMinPurchase(Integer minPurchase) {
        this.minPurchase = minPurchase;
    }

    /**
     * 获取商品状态 1 发布 2 不发布
     *
     * @return state - 商品状态 1 发布 2 不发布
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置商品状态 1 发布 2 不发布
     *
     * @param state 商品状态 1 发布 2 不发布
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取限购数量
     *
     * @return user_limit - 限购数量
     */
    public Integer getUserLimit() {
        return userLimit;
    }

    /**
     * 设置限购数量
     *
     * @param userLimit 限购数量
     */
    public void setUserLimit(Integer userLimit) {
        this.userLimit = userLimit;
    }

    /**
     * 获取1 每天 2 每周 3 每年 4 永久
     *
     * @return limit_mode - 1 每天 2 每周 3 每年 4 永久
     */
    public Integer getLimitMode() {
        return limitMode;
    }

    /**
     * 设置1 每天 2 每周 3 每年 4 永久
     *
     * @param limitMode 1 每天 2 每周 3 每年 4 永久
     */
    public void setLimitMode(Integer limitMode) {
        this.limitMode = limitMode;
    }

    /**
     * 获取商品类型 1 实物 2 虚拟
     *
     * @return commodity_type - 商品类型 1 实物 2 虚拟
     */
    public Integer getCommodityType() {
        return commodityType;
    }

    /**
     * 设置商品类型 1 实物 2 虚拟
     *
     * @param commodityType 商品类型 1 实物 2 虚拟
     */
    public void setCommodityType(Integer commodityType) {
        this.commodityType = commodityType;
    }

    /**
     * 获取商品店铺分类
     *
     * @return merchant_category_id - 商品店铺分类
     */
    public Long getMerchantCategoryId() {
        return merchantCategoryId;
    }

    /**
     * 设置商品店铺分类
     *
     * @param merchantCategoryId 商品店铺分类
     */
    public void setMerchantCategoryId(Long merchantCategoryId) {
        this.merchantCategoryId = merchantCategoryId;
    }
}