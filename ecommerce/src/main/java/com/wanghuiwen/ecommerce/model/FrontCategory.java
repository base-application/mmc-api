package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "front_category")
public class FrontCategory implements Serializable {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 分类图标
     */
    @Column(name = "category_icon")
    private String categoryIcon;

    /**
     * 分类类型 1 搜索词 2 h5地址 3 后台分类
     */
    @Column(name = "category_type")
    private Integer categoryType;

    /**
     * 排序
     */
    private Integer priority;

    /**
     * 是否禁用
     */
    private Boolean disable;

    /**
     * h5地址
     */
    @Column(name = "h5_url")
    private String h5Url;

    /**
     * 父类Id
     */
    @Column(name = "category_pid")
    private Long categoryPid;

    private static final long serialVersionUID = 1L;

    /**
     * @return category_id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
     * 获取分类图标
     *
     * @return category_icon - 分类图标
     */
    public String getCategoryIcon() {
        return categoryIcon;
    }

    /**
     * 设置分类图标
     *
     * @param categoryIcon 分类图标
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    /**
     * 获取分类类型 1 搜索词 2 h5地址 3 后台分类
     *
     * @return category_type - 分类类型 1 搜索词 2 h5地址 3 后台分类
     */
    public Integer getCategoryType() {
        return categoryType;
    }

    /**
     * 设置分类类型 1 搜索词 2 h5地址 3 后台分类
     *
     * @param categoryType 分类类型 1 搜索词 2 h5地址 3 后台分类
     */
    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
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
     * 获取是否禁用
     *
     * @return disable - 是否禁用
     */
    public Boolean getDisable() {
        return disable;
    }

    /**
     * 设置是否禁用
     *
     * @param disable 是否禁用
     */
    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    /**
     * 获取h5地址
     *
     * @return h5_url - h5地址
     */
    public String getH5Url() {
        return h5Url;
    }

    /**
     * 设置h5地址
     *
     * @param h5Url h5地址
     */
    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    /**
     * 获取父类Id
     *
     * @return category_pid - 父类Id
     */
    public Long getCategoryPid() {
        return categoryPid;
    }

    /**
     * 设置父类Id
     *
     * @param categoryPid 父类Id
     */
    public void setCategoryPid(Long categoryPid) {
        this.categoryPid = categoryPid;
    }
}