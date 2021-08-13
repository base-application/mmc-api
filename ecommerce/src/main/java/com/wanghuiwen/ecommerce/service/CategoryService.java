package com.wanghuiwen.ecommerce.service;
import com.wanghuiwen.ecommerce.model.Category;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.ecommerce.vo.CategoryTree;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/08/11.
 */
public interface CategoryService extends Service<Category> {
    void delete(Long categoryId);

    /**
     * 返回分类树结构
     * @return
     */
    List<CategoryTree> tree();
}
