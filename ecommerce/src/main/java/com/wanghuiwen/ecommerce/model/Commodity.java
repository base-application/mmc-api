package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

public class Commodity implements Serializable {
    @Id
    @Column(name = "commodity_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 运费模版
     */
    @Column(name = "carriage_template_id")
    private Long carriageTemplateId;

    /**
     * 商品状态 1 发布 2 不发布
     */
    private Integer state;

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

    /**
     * 减库存方式 1 下单立减 2 付款减库存
     */
    @Column(name = "stock_mode")
    private Byte stockMode;

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

    /**
     * 获取减库存方式 1 下单立减 2 付款减库存
     *
     * @return stock_mode - 减库存方式 1 下单立减 2 付款减库存
     */
    public Byte getStockMode() {
        return stockMode;
    }

    /**
     * 设置减库存方式 1 下单立减 2 付款减库存
     *
     * @param stockMode 减库存方式 1 下单立减 2 付款减库存
     */
    public void setStockMode(Byte stockMode) {
        this.stockMode = stockMode;
    }
}