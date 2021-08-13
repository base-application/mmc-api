package com.wanghuiwen.ecommerce.controller;

import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.ecommerce.config.EcommerceResultEnum;
import com.wanghuiwen.ecommerce.model.Category;
import com.wanghuiwen.ecommerce.model.FrontCategory;
import com.wanghuiwen.ecommerce.model.Manager;
import com.wanghuiwen.ecommerce.model.MerchantCategory;
import com.wanghuiwen.ecommerce.service.CategoryService;
import com.wanghuiwen.ecommerce.service.FrontCategoryService;
import com.wanghuiwen.ecommerce.service.ManagerService;
import com.wanghuiwen.ecommerce.service.MerchantCategoryService;
import com.wanghuiwen.ecommerce.vo.CategoryTree;
import com.wanghuiwen.ecommerce.vo.FrontCategoryAdd;
import com.wanghuiwen.ecommerce.vo.FrontCategoryTree;
import com.wanghuiwen.ecommerce.vo.MerchantCategoryTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
* Created by wanghuiwen on 2021/08/11.
*/
@Api(value = "分类", tags = {"分类"})
@RestController
@RequestMapping("/category")
public class CategoryController extends Ctrl{
    @Resource
    private CategoryService categoryService;
    @Resource
    private MerchantCategoryService merchantCategoryService;
    @Resource
    private FrontCategoryService frontCategoryService;
    @Resource
    private ManagerService managerService;

    @ApiOperation(value = "系统分类添加", tags = {"分类"}, notes = "系统分类添加")
    @PutMapping(value="/add",name="系统分类添加")
    public Result add(@RequestBody Category category) {
        categoryService.saveOrUpdate(category);
        return resultGenerator.genSuccessResult(category.getCategoryId());
    }

    @ApiOperation(value = "系统分类列表", tags = {"分类"}, notes = "系统分类列表")
    @GetMapping(value="/list",name="系统分类列表")
    public Result categoryList() {
        List<CategoryTree> categoryTrees = categoryService.tree();
        return resultGenerator.genSuccessResult(categoryTrees);
    }

    @ApiOperation(value = "系统分类删除", tags = {"分类"}, notes = "系统分类删除")
    @DeleteMapping(value="/delete",name="系统分类删除")
    public Result deleteCategory(Long categoryId) {
        categoryService.delete(categoryId);
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "商户分类添加", tags = {"分类"}, notes = "商户分类添加")
    @PutMapping(value="/merchant/add",name="商户分类添加")
    public Result merchantAdd(@RequestBody MerchantCategory category, Authentication authentication) {
        AuthUser user = getAuthUser(authentication);
        Manager manager = managerService.findById(user.getId());
        if(manager==null){
            return resultGenerator.genFailResult(EcommerceResultEnum.ONLY_MERCHANT);
        }
        category.setMerchantId(manager.getMerchantId());
        merchantCategoryService.saveOrUpdate(category);
        return resultGenerator.genSuccessResult(category.getMerchantCategoryId());
    }


    @ApiOperation(value = "商户分类列表", tags = {"分类"}, notes = "商户分类列表")
    @GetMapping(value="/merchant/list",name="商户分类列表")
    public Result merchantCategoryList() {
        List<MerchantCategory> categoryList = merchantCategoryService.findAll();
        List<MerchantCategoryTree> categoryTrees =  merchantCategoryService.addCategoryChild(categoryList);
        return resultGenerator.genSuccessResult(categoryTrees);
    }

    @ApiOperation(value = "商户分类删除", tags = {"分类"}, notes = "商户分类删除")
    @DeleteMapping(value="/merchant/delete",name="商户分类删除")
    public Result deleteMerchantCategory(Long categoryId) {
        merchantCategoryService.delete(categoryId);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "前端分类添加", tags = {"分类"}, notes = "前端分类添加")
    @PutMapping(value="/front/add",name="前端分类添加")
    public Result frontAdd(@RequestBody FrontCategoryAdd category) {
        return resultGenerator.genSuccessResult(frontCategoryService.saveOrUpdate(category));
    }


    @ApiOperation(value = "前端分类列表", tags = {"分类"}, notes = "前端分类列表")
    @GetMapping(value="/front/list",name="前端分类列表")
    public Result frontCategoryList() {
        List<FrontCategoryTree> categoryTrees =  frontCategoryService.tree();
        return resultGenerator.genSuccessResult(categoryTrees);
    }

    @ApiOperation(value = "前端分类删除", tags = {"分类"}, notes = "前端分类删除")
    @DeleteMapping(value="/front/delete",name="前端分类删除")
    public Result deleteFrontCategory(Long categoryId) {
        frontCategoryService.delete(categoryId);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "前端分类详情", tags = {"分类"}, notes = "前端分类详情")
    @GetMapping(value="/front/detail",name="前端分类详情")
    public Result frontCategoryDetail(Long categoryId) {
        FrontCategoryAdd categoryTrees =  frontCategoryService.detail(categoryId);
        return resultGenerator.genSuccessResult(categoryTrees);
    }

}
