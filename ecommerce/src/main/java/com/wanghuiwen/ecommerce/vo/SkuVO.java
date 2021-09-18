package com.wanghuiwen.ecommerce.vo;

import java.util.List;

public class SkuVO {
    /**
     * 商品关联的属性
     */
    List<SpaceAttributeVo> spaceAttributes;

    /**
     * 商品规格
     */
    List<CommoditySkuVo> specs;

    public List<SpaceAttributeVo> getSpaceAttributes() {
        return spaceAttributes;
    }

    public void setSpaceAttributes(List<SpaceAttributeVo> spaceAttributes) {
        this.spaceAttributes = spaceAttributes;
    }

    public List<CommoditySkuVo> getSpecs() {
        return specs;
    }

    public void setSpecs(List<CommoditySkuVo> specs) {
        this.specs = specs;
    }
}
