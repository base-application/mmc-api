package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

public class Category implements Serializable {
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
     * 父类id
     */
    @Column(name = "category_pid")
    private Long categoryPid;

    /**
     * 排序
     */
    private Long priority;

    /**
     * 是否启用
     */
    private Boolean disable;

    /**
     * 分类图标
     */
    @Column(name = "category_icon")
    private String categoryIcon;

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
     * 获取父类id
     *
     * @return category_pid - 父类id
     */
    public Long getCategoryPid() {
        return categoryPid;
    }

    /**
     * 设置父类id
     *
     * @param categoryPid 父类id
     */
    public void setCategoryPid(Long categoryPid) {
        this.categoryPid = categoryPid;
    }

    /**
     * 获取排序
     *
     * @return priority - 排序
     */
    public Long getPriority() {
        return priority;
    }

    /**
     * 设置排序
     *
     * @param priority 排序
     */
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    /**
     * 获取是否启用
     *
     * @return disable - 是否启用
     */
    public Boolean getDisable() {
        return disable;
    }

    /**
     * 设置是否启用
     *
     * @param disable 是否启用
     */
    public void setDisable(Boolean disable) {
        this.disable = disable;
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
}