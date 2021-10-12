package com.wanghuiwen.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "front_category_item")
public class FrontCategoryItem implements Serializable {
    @Column(name = "front_category_id")
    private Long frontCategoryId;

    @Id
    @Column(name = "category_id")
    private Long categoryId;

    private static final long serialVersionUID = 1L;

    /**
     * @return front_category_id
     */
    public Long getFrontCategoryId() {
        return frontCategoryId;
    }

    /**
     * @param frontCategoryId
     */
    public void setFrontCategoryId(Long frontCategoryId) {
        this.frontCategoryId = frontCategoryId;
    }

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
}