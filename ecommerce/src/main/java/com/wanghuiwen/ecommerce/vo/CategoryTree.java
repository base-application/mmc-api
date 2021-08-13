package com.wanghuiwen.ecommerce.vo;

import com.wanghuiwen.ecommerce.model.Category;

import java.util.List;

public class CategoryTree extends Category {
    List<CategoryTree> children ;

    public List<CategoryTree> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryTree> children) {
        this.children = children;
    }
}
