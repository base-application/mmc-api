package com.wanghuiwen.ecommerce.service;
import com.wanghuiwen.ecommerce.model.MerchantCategory;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.ecommerce.vo.CategoryTree;
import com.wanghuiwen.ecommerce.vo.MerchantCategoryTree;

import java.util.List;

/**
 * Created by wanghuiwen on 2021/08/11.
 */
public interface MerchantCategoryService extends Service<MerchantCategory> {
    /**
     * 返回分类树结构
     * @param categoryList
     * @return
     */
    List<MerchantCategoryTree> addCategoryChild(List<MerchantCategory> categoryList);

    void delete(Long categoryId);
}
