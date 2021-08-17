package com.wanghuiwen.ecommerce.controller;

import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.ecommerce.service.CommodityService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;



/**
* Created by wanghuiwen on 2021/08/13.
*/
@Api(value = "commodity", tags = {"commodity"})
@RestController
@RequestMapping("/commodity")
public class CommodityController extends Ctrl{
    @Resource
    private CommodityService commodityService;
}
