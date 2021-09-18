package com.wanghuiwen.ecommerce.service;
import com.wanghuiwen.ecommerce.model.Commodity;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.ecommerce.vo.CommodityAddVo;
import com.wanghuiwen.ecommerce.vo.SkuVO;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghuiwen on 2021/08/13.
 */
public interface CommodityService extends Service<Commodity> {
    List<Commodity> list(Map<String, Object> params);

    Long saveAdd(CommodityAddVo commodity);

    /**
     * 保存商品规格
     * @param skuVO 规格
     */
    void skuSave(SkuVO skuVO);
}
