package com.wanghuiwen.ecommerce.service;
import com.wanghuiwen.ecommerce.model.FrontCategory;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.ecommerce.vo.FrontCategoryAdd;
import com.wanghuiwen.ecommerce.vo.FrontCategoryTree;
import com.wanghuiwen.ecommerce.vo.MerchantCategoryTree;

import java.util.List;

/**
 * Created by wanghuiwen on 2021/08/11.
 */
public interface FrontCategoryService extends Service<FrontCategory> {

   Long saveOrUpdate(FrontCategoryAdd frontCategory);

    List<FrontCategoryTree> tree();

    FrontCategoryAdd detail(Long categoryId);

    void delete(Long categoryId);
}
