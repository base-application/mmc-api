package com.wanghuiwen.ecommerce.controller;

import com.github.pagehelper.PageHelper;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.ecommerce.model.Commodity;
import com.wanghuiwen.ecommerce.model.SpecsValue;
import com.wanghuiwen.ecommerce.service.CommodityService;
import com.wanghuiwen.ecommerce.vo.CommodityAddVo;
import com.wanghuiwen.ecommerce.vo.SkuVO;
import com.wanghuiwen.ecommerce.vo.SpaceAttributeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static com.wanghuiwen.ecommerce.config.EcommerceResultEnum.ATTRIBUTE_DISTINCT_NAME;


/**
* Created by wanghuiwen on 2021/08/13.
*/
@Api(value = "商品", tags = {"商品"})
@RestController
@RequestMapping("/commodity")
public class CommodityController extends Ctrl{
    @Resource
    private CommodityService commodityService;

    @ApiOperation(value = "商品列表", tags = {"商品"}, notes = "notes")
    @GetMapping(value = "/list",name = "商品列表")
    public Result commodityList(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        Map<String,Object> params = new HashMap<>();
        PageHelper.startPage(page, size);
        List<Commodity> commodities = commodityService.list(params);
        return  resultGenerator.genSuccessResult(commodities);
    }


    @ApiOperation(value = "商品保存基本信息", tags = {"商品"}, notes = "商品保存基本信息")
    @PostMapping(value = "/save",name = "商品保存基本信息")
    public Result commoditySave(@RequestBody  CommodityAddVo commodity){

        return  resultGenerator.genSuccessResult(commodityService.saveAdd(commodity));
    }


    @ApiOperation(value = "商品保存SKU信息", tags = {"商品"}, notes = "商品保存SKU信息")
    @PostMapping(value = "/sku/save",name = "商品保存SKU信息")
    public Result skuSave(@RequestBody SkuVO skuVO){

        //todo 规格查重
        List<String> attrName =  skuVO.getSpaceAttributes().stream().map(SpaceAttributeVo::getAttributeName).collect(Collectors.toList());
        Set<String> noRepeatSet = new HashSet<>(attrName);
        if(noRepeatSet.size() != attrName.size()){
            resultGenerator.genFailResult(ATTRIBUTE_DISTINCT_NAME);
        }
        List<String> values = new ArrayList<>();
        for (SpaceAttributeVo spaceAttribute : skuVO.getSpaceAttributes()) {
            values.addAll(spaceAttribute.getValue().stream().map(SpecsValue::getAttributeValue).collect(Collectors.toList()));
        }
        Set<String> valueSet = new HashSet<>(values);
        if(values.size() != valueSet.size()){
            resultGenerator.genFailResult(ATTRIBUTE_DISTINCT_NAME);
        }
        commodityService.skuSave(skuVO);
        return  resultGenerator.genSuccessResult(skuVO);
    }
}
