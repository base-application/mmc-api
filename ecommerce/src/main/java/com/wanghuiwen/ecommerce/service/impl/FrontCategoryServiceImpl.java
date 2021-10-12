package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.ecommerce.dao.CategoryMapper;
import com.wanghuiwen.ecommerce.dao.FrontCategoryItemMapper;
import com.wanghuiwen.ecommerce.dao.FrontCategoryMapper;
import com.wanghuiwen.ecommerce.model.Category;
import com.wanghuiwen.ecommerce.model.FrontCategory;
import com.wanghuiwen.ecommerce.model.FrontCategoryItem;
import com.wanghuiwen.ecommerce.model.MerchantCategory;
import com.wanghuiwen.ecommerce.service.FrontCategoryService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.ecommerce.vo.FrontCategoryAdd;
import com.wanghuiwen.ecommerce.vo.FrontCategoryTree;
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
public class FrontCategoryServiceImpl extends AbstractService<FrontCategory> implements FrontCategoryService {
    @Resource
    private FrontCategoryMapper frontCategoryMapper;
    @Resource
    private FrontCategoryItemMapper frontCategoryItemMapper;
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public Long saveOrUpdate(FrontCategoryAdd frontCategory) {
        if(frontCategory.getCategoryId()!=null){
            frontCategoryMapper.updateByPrimaryKeySelective(frontCategory);
        }else {
            frontCategoryMapper.insertSelective(frontCategory);
        }

        if(!CollectionUtils.isEmpty(frontCategory.getCategories())){
            List<FrontCategoryItem> items = new ArrayList<>();
            for (Category category : frontCategory.getCategories()) {
                FrontCategoryItem item = new FrontCategoryItem();
                item.setCategoryId(category.getCategoryId());
                item.setFrontCategoryId(frontCategory.getCategoryId());
                items.add(item);
            }
            frontCategoryItemMapper.deleteByFrontCategoryId(frontCategory.getCategoryId());
            frontCategoryItemMapper.insertListNoAuto(items);
        }

        return frontCategory.getCategoryId();
    }

    @Override
    public List<FrontCategoryTree> tree() {
        List<FrontCategory> categoryList = findAll();

        Map<Long,List<FrontCategory>> group = categoryList.stream().collect(Collectors.groupingBy(FrontCategory::getCategoryPid));
        if(CollectionUtils.isEmpty(group)){
            return new ArrayList<>();
        }
        return addCategoryChild(group.get(0L),group);
    }


    private List<FrontCategoryTree> addCategoryChild(List<FrontCategory> categories, Map<Long, List<FrontCategory>> res){
        List<FrontCategoryTree> categoryTrees = new ArrayList<>();
        for (FrontCategory category : categories) {
            FrontCategoryTree tree = new FrontCategoryTree();
            BeanUtils.copyProperties(category,tree);
            if(!CollectionUtils.isEmpty(res.get(category.getCategoryId()))){
                tree.setChildren(addCategoryChild(res.get(category.getCategoryId()),res));
            }
            categoryTrees.add(tree);
        }
        return categoryTrees;
    }

    @Override
    public FrontCategoryAdd detail(Long categoryId) {
        FrontCategory category = findById(categoryId);
        FrontCategoryAdd add = new FrontCategoryAdd();
        BeanUtils.copyProperties(category,add);
        List<Category> categories = categoryMapper.findFront(categoryId);
        add.setCategories(categories);
        return add ;
    }

    @Override
    public void delete(Long categoryId) {
        List<FrontCategory> categories = frontCategoryMapper.findChild(categoryId);
        if(!CollectionUtils.isEmpty(categories)){
            throw new ServiceException("分类下已经有子分类，无法删除","category.not.delete");
        }
        frontCategoryItemMapper.deleteByFrontCategoryId(categoryId);
        deleteById(categoryId);
    }
}
