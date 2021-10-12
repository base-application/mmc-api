package com.wanghuiwen.ecommerce.vo;

import com.wanghuiwen.ecommerce.model.FrontCategory;

import java.util.List;

public class FrontCategoryTree extends FrontCategory {
    List<FrontCategoryTree> children;

    public List<FrontCategoryTree> getChildren() {
        return children;
    }

    public void setChildren(List<FrontCategoryTree> children) {
        this.children = children;
    }
}
