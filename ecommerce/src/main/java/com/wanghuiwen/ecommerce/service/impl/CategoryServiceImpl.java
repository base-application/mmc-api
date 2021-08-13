package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.ecommerce.dao.CategoryMapper;
import com.wanghuiwen.ecommerce.dao.MerchantCategoryMapper;
import com.wanghuiwen.ecommerce.model.Category;
import com.wanghuiwen.ecommerce.model.MerchantCategory;
import com.wanghuiwen.ecommerce.service.CategoryService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.ecommerce.vo.CategoryTree;
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
public class CategoryServiceImpl extends AbstractService<Category> implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private MerchantCategoryMapper merchantCategoryMapper;

    @Override
    public void delete(Long categoryId) {
        List<Category> categoryList = categoryMapper.selectChild(categoryId);
        //todo 判断分类下是否有商品
        if(!CollectionUtils.isEmpty(categoryList)){
            throw  new ServiceException("分类下已经有子分类，无法删除","category.not.delete");
        }
        categoryMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public List<CategoryTree> tree() {
        List<Category> categoryList = findAll();
        Map<Long,List<Category>> group = categoryList.stream().collect(Collectors.groupingBy(Category::getCategoryPid));
        if(CollectionUtils.isEmpty(group)){
            return new ArrayList<>();
        }
        return addCategoryChild(group.get(0L),group);
    }
    private List<CategoryTree> addCategoryChild(List<Category> categories, Map<Long, List<Category>> res){
        List<CategoryTree> categoryTrees = new ArrayList<>();
        for (Category category : categories) {
            CategoryTree tree = new CategoryTree();
            BeanUtils.copyProperties(category,tree);
            if(!CollectionUtils.isEmpty(res.get(category.getCategoryId()))){
                tree.setChildren(addCategoryChild(res.get(category.getCategoryId()),res));
            }
            categoryTrees.add(tree);
        }
        return categoryTrees;
    }
}
