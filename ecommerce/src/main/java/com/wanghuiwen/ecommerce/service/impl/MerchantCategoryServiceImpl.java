package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.ecommerce.dao.MerchantCategoryMapper;
import com.wanghuiwen.ecommerce.model.Category;
import com.wanghuiwen.ecommerce.model.MerchantCategory;
import com.wanghuiwen.ecommerce.service.MerchantCategoryService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.ecommerce.vo.CategoryTree;
import com.wanghuiwen.ecommerce.vo.MerchantCategoryTree;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/08/11.
 */
@Service
@Transactional
public class MerchantCategoryServiceImpl extends AbstractService<MerchantCategory> implements MerchantCategoryService {
    @Resource
    private MerchantCategoryMapper merchantCategoryMapper;

    @Override
    public List<MerchantCategoryTree> addCategoryChild(List<MerchantCategory> categoryList) {
        Map<Long,List<MerchantCategory>> group = categoryList.stream().collect(Collectors.groupingBy(MerchantCategory::getMerchantCategoryPid));
        if(CollectionUtils.isEmpty(group)){
            return new ArrayList<>();
        }
        return addCategoryChild(group.get(0L),group);
    }

    private List<MerchantCategoryTree> addCategoryChild(List<MerchantCategory> categories, Map<Long, List<MerchantCategory>> res){
        List<MerchantCategoryTree> categoryTrees = new ArrayList<>();
        for (MerchantCategory category : categories) {
            MerchantCategoryTree tree = new MerchantCategoryTree();
            BeanUtils.copyProperties(category,tree);
            if(!CollectionUtils.isEmpty(res.get(category.getMerchantCategoryId()))){
                tree.setChildren(addCategoryChild(res.get(category.getMerchantCategoryId()),res));
            }
            categoryTrees.add(tree);
        }
        return categoryTrees;
    }

    @Override
    public void delete(Long categoryId) {

        //todo 判断分类下是否有商品

        //todo 判断分类是是否有分类
        List<MerchantCategory> categories = merchantCategoryMapper.getChild(categoryId);
        if(!CollectionUtils.isEmpty(categories)){
            throw  new ServiceException("分类下已经有子分类，无法删除","category.not.delete");
        }
        deleteById(categoryId);
    }
}
