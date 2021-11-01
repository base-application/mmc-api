package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.service.SliderService;
import com.wanghuiwen.user.vo.ReferralVo;
import com.wanghuiwen.user.vo.SliderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by wanghuiwen on 2021/10/22.
 */
@Api(value = "轮播图", tags = {"轮播图"})
@RestController
@RequestMapping("/slider")
public class SliderController extends Ctrl {
    @Resource
    private SliderService sliderService;

    @ApiOperation(value = "轮播图添加", tags = {"轮播图"}, notes = "轮播图添加")
    @PostMapping(value = "/add", name = "轮播图添加")
    public Result add(@RequestBody SliderVo slider) {
        sliderService.add(slider);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "轮播图添加", tags = {"轮播图"}, notes = "轮播图添加")
    @DeleteMapping(value = "/delete", name = "轮播图添加")
    public Result delete(Integer id) {
        sliderService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "轮播图列表", tags = {"轮播图"}, notes = "轮播图列表")
    @GetMapping(value = "/list", name = "轮播图列表")
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<SliderVo> sliderVos = sliderService.list();
        PageInfo<SliderVo> pageInfo = new PageInfo<>(sliderVos);
        return resultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "用户端轮播图", tags = {"轮播图"}, notes = "用户端轮播图")
    @GetMapping(value = "/list/user", name = "用户端轮播图")
    public Result userList(@RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "10") Integer size,
                           Authentication authentication) {
        PageHelper.startPage(page, size);
        List<SliderVo> sliderVos = sliderService.userList(getAuthUser(authentication).getId());
        PageInfo<SliderVo> pageInfo = new PageInfo<>(sliderVos);
        return resultGenerator.genSuccessResult(pageInfo);
    }
}
