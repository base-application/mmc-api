package com.wanghuiwen.ecommerce.service.impl;

import com.wanghuiwen.ecommerce.dao.*;
import com.wanghuiwen.ecommerce.model.*;
import com.wanghuiwen.ecommerce.service.CommodityService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.ecommerce.service.CommoditySkuAttrService;
import com.wanghuiwen.ecommerce.service.CommoditySlideService;
import com.wanghuiwen.ecommerce.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/08/13.
 */
@Service
@Transactional
public class CommodityServiceImpl extends AbstractService<Commodity> implements CommodityService {
    @Resource
    private CommodityMapper commodityMapper;
    @Resource
    private CommoditySlideService commoditySlideService;

    @Resource
    private SpecsAttributeMapper specsAttributeMapper;
    @Resource
    private SpecsValueMapper specsValueMapper;

    @Resource
    private CommoditySkuMapper commoditySkuMapper;

    @Resource
    private CommoditySkuAttrMapper commoditySkuAttrMapper;

    @Override
    public List<Commodity> list(Map<String, Object> params) {

        return commodityMapper.selectAll();
    }

    @Override
    public Long saveAdd(CommodityAddVo commodityAdd) {
        Commodity commodity = new Commodity();
        BeanUtils.copyProperties(commodityAdd,commodity);
        saveOrUpdate(commodity);
        /**
         * 保存商品轮播图
         */
        if(!CollectionUtils.isEmpty(commodityAdd.getSlide())){
            /**
             * 删除轮播图  查到原有的和现有的对比
             */
            List<CommoditySlide> oldSlides = commoditySlideService.findByCommodityId(commodityAdd.getCommodityId());
            List<CommoditySlide> removeSlides = commodityAdd.getSlide().stream().filter(commoditySlide -> !oldSlides.stream().map(CommoditySlide::getSlideId).collect(Collectors.toList()).contains(commoditySlide.getSlideId())).collect(Collectors.toList());
            for (CommoditySlide removeSlide : removeSlides) {
                commoditySlideService.deleteById(removeSlide);
            }
            /**
             * 保存或者更新品轮播图
             */
            for (CommoditySlide commoditySlide : commodityAdd.getSlide()) {
                commoditySlide.setCommodityId(commodity.getCommodityId());
                commoditySlideService.saveOrUpdate(commoditySlide);
            }
        }
        return commodity.getCommodityId();
    }

    @Override
    public void skuSave(SkuVO skuVO) {
        /**
         * 保存规格属性
         */
        for (SpaceAttributeVo spaceAttribute : skuVO.getSpaceAttributes()) {
            SpecsAttribute specsAttribute = new SpecsAttribute();
            specsAttribute.setAttributeName(spaceAttribute.getAttributeName());
            spaceAttribute.setCommodityId(spaceAttribute.getCommodityId());
            if(spaceAttribute.getAttributeId()!=null){
                specsAttribute.setAttributeId(spaceAttribute.getAttributeId());
                specsAttributeMapper.updateByPrimaryKeySelective(specsAttribute);
            }else {
                specsAttributeMapper.insert(specsAttribute);
            }
            spaceAttribute.setAttributeId(specsAttribute.getAttributeId());
            for (SpecsValue specsValue : spaceAttribute.getValue()) {
                specsValue.setAttributeId(specsAttribute.getAttributeId());
                if(specsValue.getAttributeValueId()!=null){
                    specsValueMapper.updateByPrimaryKeySelective(specsValue);
                }else {
                    specsValueMapper.insert(specsValue);
                }
            }
        }

        /**
         * 保存商品规格
         */
        for (CommoditySkuVo spec : skuVO.getSpecs()) {
            CommoditySku sku = new CommoditySku();
            sku.setCostPrice(spec.getCostPrice());
            sku.setSpecsImage(spec.getSpecsImage());
            sku.setSpecsName(spec.getSpecsName());
            sku.setSpecsPrice(spec.getSpecsPrice());
            sku.setSpecsStock(spec.getSpecsStock());
            sku.setWeight(spec.getWeight());
            sku.setCommodityId(skuVO.getSpaceAttributes().get(0).getCommodityId());
            if(spec.getSpecsId()!=null){
                sku.setSpecsId(spec.getSpecsId());
                commoditySkuMapper.updateByPrimaryKeySelective(sku);
            }else {
                commoditySkuMapper.insert(sku);
                spec.setSpecsId(sku.getSpecsId());
                spec.setCommodityId(sku.getCommodityId());
            }
            for (SkuAttributeValue skuAttributeValue : spec.getSkuAttributeValue()) {
                commoditySkuAttrMapper.deleteBySpec(sku.getSpecsId());
                CommoditySkuAttr skuAttr = new CommoditySkuAttr();
                skuAttr.setCommoditySkuId(sku.getSpecsId());

                Optional<SpaceAttributeVo>  spaceAttributeVo =  skuVO.getSpaceAttributes().stream().filter(s -> s.getAttributeName().equals(skuAttributeValue.getAttributeName())).findFirst();

                if(spaceAttributeVo.isPresent()){
                    skuAttr.setSpecsAttributeId(spaceAttributeVo.get().getAttributeId());
                }

                SpecsValue value = spaceAttributeVo.get().getValue().stream().filter( v -> v.getAttributeValue().equals(skuAttributeValue.getAttributeValue())).findFirst().get();
                skuAttr.setSpecsValueId(value.getAttributeValueId());
                commoditySkuAttrMapper.insert(skuAttr);
            }

        }
    }
}
