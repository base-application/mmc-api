package com.wanghuiwen.ecommerce.vo;

import com.wanghuiwen.ecommerce.model.MerchantCategory;

import java.util.List;

public class MerchantCategoryTree  extends MerchantCategory {
    List<MerchantCategoryTree> children ;

    public List<MerchantCategoryTree> getChildren() {
        return children;
    }

    public void setChildren(List<MerchantCategoryTree> children) {
        this.children = children;
    }
}