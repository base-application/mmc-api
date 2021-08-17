package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "commodity_sku")
public class CommoditySku implements Serializable {
    @Id
    @Column(name = "specs_id")
    private Long specsId;

    /**
     * 商品ID
     */
    @Column(name = "commodity_id")
    private Long commodityId;

    /**
     * 规格名称{"颜色"："白色"}
     */
    @Column(name = "specs_name")
    private String specsName;

    /**
     * 规格图片
     */
    @Column(name = "specs_image")
    private String specsImage;

    /**
     * 库存
     */
    @Column(name = "specs_stock")
    private String specsStock;

    /**
     * 单价
     */
    @Column(name = "specs_price")
    private BigDecimal specsPrice;

    /**
     * 规格 {属性id：属性值id}
     */
    @Column(name = "specs_attr")
    private String specsAttr;

    /**
     * 成本价
     */
    @Column(name = "cost_price")
    private BigDecimal costPrice;

    /**
     * 重量
     */
    private Double weight;

    private static final long serialVersionUID = 1L;

    /**
     * @return specs_id
     */
    public Long getSpecsId() {
        return specsId;
    }

    /**
     * @param specsId
     */
    public void setSpecsId(Long specsId) {
        this.specsId = specsId;
    }

    /**
     * 获取商品ID
     *
     * @return commodity_id - 商品ID
     */
    public Long getCommodityId() {
        return commodityId;
    }

    /**
     * 设置商品ID
     *
     * @param commodityId 商品ID
     */
    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * 获取规格名称{"颜色"："白色"}
     *
     * @return specs_name - 规格名称{"颜色"："白色"}
     */
    public String getSpecsName() {
        return specsName;
    }

    /**
     * 设置规格名称{"颜色"："白色"}
     *
     * @param specsName 规格名称{"颜色"："白色"}
     */
    public void setSpecsName(String specsName) {
        this.specsName = specsName;
    }

    /**
     * 获取规格图片
     *
     * @return specs_image - 规格图片
     */
    public String getSpecsImage() {
        return specsImage;
    }

    /**
     * 设置规格图片
     *
     * @param specsImage 规格图片
     */
    public void setSpecsImage(String specsImage) {
        this.specsImage = specsImage;
    }

    /**
     * 获取库存
     *
     * @return specs_stock - 库存
     */
    public String getSpecsStock() {
        return specsStock;
    }

    /**
     * 设置库存
     *
     * @param specsStock 库存
     */
    public void setSpecsStock(String specsStock) {
        this.specsStock = specsStock;
    }

    /**
     * 获取单价
     *
     * @return specs_price - 单价
     */
    public BigDecimal getSpecsPrice() {
        return specsPrice;
    }

    /**
     * 设置单价
     *
     * @param specsPrice 单价
     */
    public void setSpecsPrice(BigDecimal specsPrice) {
        this.specsPrice = specsPrice;
    }

    /**
     * 获取规格 {属性id：属性值id}
     *
     * @return specs_attr - 规格 {属性id：属性值id}
     */
    public String getSpecsAttr() {
        return specsAttr;
    }

    /**
     * 设置规格 {属性id：属性值id}
     *
     * @param specsAttr 规格 {属性id：属性值id}
     */
    public void setSpecsAttr(String specsAttr) {
        this.specsAttr = specsAttr;
    }

    /**
     * 获取成本价
     *
     * @return cost_price - 成本价
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    /**
     * 设置成本价
     *
     * @param costPrice 成本价
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * 获取重量
     *
     * @return weight - 重量
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 设置重量
     *
     * @param weight 重量
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }
}