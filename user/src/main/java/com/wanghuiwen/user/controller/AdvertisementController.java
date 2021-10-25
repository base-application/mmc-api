package com.wanghuiwen.user.controller;

import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.model.Advertisement;
import com.wanghuiwen.user.service.AdvertisementService;
import io.swagger.annotations.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



/**
* Created by wanghuiwen on 2021/10/25.
*/
@Api(value = "广告", tags = {"广告"})
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController extends Ctrl{
    @Resource
    private AdvertisementService advertisementService;

    @ApiOperation(value = "广告添加", tags = {"广告"}, notes = "广告添加")
    @PostMapping(value="/add",name="广告添加")
    public Result add(@ApiParam Advertisement advertisement) {
        advertisementService.save(advertisement);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "广告删除", tags = {"广告"}, notes = "广告删除")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",required=true, value = "广告id", dataType = "Long", paramType = "query")
    })
    @DeleteMapping(value="/delete",name="广告删除")
    public Result delete(@RequestParam Long id) {
        advertisementService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "广告列表信息", tags = {"广告"}, notes = "广告列表信息")
    @GetMapping(value = "/list", name = "广告列表信息")
    public Result list() {
        return resultGenerator.genSuccessResult(advertisementService.findAll());
    }

    @ApiOperation(value = "广告列表信息", tags = {"广告"}, notes = "广告列表信息")
    @GetMapping(value = "/pull", name = "广告列表信息")
    public Result pull(Authentication authentication) {
        return resultGenerator.genSuccessResult(advertisementService.pull(getAuthUser(authentication)));
    }
}
