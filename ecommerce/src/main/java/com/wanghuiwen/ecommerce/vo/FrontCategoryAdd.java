package com.wanghuiwen.ecommerce.vo;

import com.wanghuiwen.ecommerce.model.Category;
import com.wanghuiwen.ecommerce.model.FrontCategory;

import java.util.List;

public class FrontCategoryAdd extends FrontCategory {
    List<Category> categories ;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
