package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "merchant_category")
public class MerchantCategory implements Serializable {
    @Id
    @Column(name = "merchant_category_id")
    private Long merchantCategoryId;

    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 公共分类ID
     */
    @Column(name = "merchant_category_pid")
    private Long merchantCategoryPid;

    /**
     * 排序
     */
    private Integer priority;

    /**
     * 商户ID
     */
    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "category_icon")
    private String categoryIcon;

    private static final long serialVersionUID = 1L;

    /**
     * @return merchant_category_id
     */
    public Long getMerchantCategoryId() {
        return merchantCategoryId;
    }

    /**
     * @param merchantCategoryId
     */
    public void setMerchantCategoryId(Long merchantCategoryId) {
        this.merchantCategoryId = merchantCategoryId;
    }

    /**
     * 获取分类名称
     *
     * @return category_name - 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名称
     *
     * @param categoryName 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取公共分类ID
     *
     * @return merchant_category_pid - 公共分类ID
     */
    public Long getMerchantCategoryPid() {
        return merchantCategoryPid;
    }

    /**
     * 设置公共分类ID
     *
     * @param merchantCategoryPid 公共分类ID
     */
    public void setMerchantCategoryPid(Long merchantCategoryPid) {
        this.merchantCategoryPid = merchantCategoryPid;
    }

    /**
     * 获取排序
     *
     * @return priority - 排序
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置排序
     *
     * @param priority 排序
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取商户ID
     *
     * @return merchant_id - 商户ID
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户ID
     *
     * @param merchantId 商户ID
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return category_icon
     */
    public String getCategoryIcon() {
        return categoryIcon;
    }

    /**
     * @param categoryIcon
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }
}