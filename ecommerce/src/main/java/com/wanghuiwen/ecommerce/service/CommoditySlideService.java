package com.wanghuiwen.ecommerce.service;
import com.wanghuiwen.ecommerce.model.CommoditySlide;
import com.wanghuiwen.core.service.Service;
import com.wanghuiwen.core.response.Result;

import java.util.List;

/**
 * Created by wanghuiwen on 2021/08/13.
 */
public interface CommoditySlideService extends Service<CommoditySlide> {

    List<CommoditySlide> findByCommodityId(Long commodityId);
}
