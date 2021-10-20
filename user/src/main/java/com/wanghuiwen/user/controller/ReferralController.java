package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.model.Referral;
import com.wanghuiwen.user.service.ReferralService;
import com.wanghuiwen.user.vo.NewestStoryVo;
import com.wanghuiwen.user.vo.ReferralAddVo;
import com.wanghuiwen.user.vo.ReferralVo;
import io.swagger.annotations.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* Created by wanghuiwen on 2021/10/20.
*/
@Api(value = "推荐", tags = {"推荐"})
@RestController
@RequestMapping("/referral")
public class ReferralController extends Ctrl{
    @Resource
    private ReferralService referralService;

    @ApiOperation(value = "发送推荐", tags = {"推荐"}, notes = "发送推荐")
    @PostMapping(value="/send",name="发送推荐")
    public Result add(@ApiParam ReferralAddVo addVo) {
        referralService.send(addVo);
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "用户接收referral", tags = {"推荐"}, notes = "用户接收referral")
    @PostMapping(value="/received",name="用户接收referral")
    public Result received(
            @RequestParam Long referralId,
            @RequestParam Integer status,
            @RequestParam(required = false) String failMessage
    ) {
        referralService.received(referralId,status,failMessage);
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "推荐列表信息", tags = {"推荐"}, notes = "推荐列表信息")
    @GetMapping(value = "/list", name = "推荐列表信息")
    public Result list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam String name,
            @RequestParam Long startTime,
            @RequestParam Long endTime,
            @RequestParam Long groupId
    ) {

        Map<String,Object> params = new HashMap<>();
        params.put("name",name);
        params.put("startTime",startTime);
        params.put("endTime",endTime);
        params.put("groupId",groupId);
        PageHelper.startPage(page,size);
        List<ReferralVo> vos = referralService.list(params);
        PageInfo<ReferralVo> pageInfo = new PageInfo<>(vos);
        return resultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "用户收到的referral", tags = {"推荐"}, notes = "用户收到的referral")
    @GetMapping(value = "/user/list", name = "用户收到的referral")
    public Result userList(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            Authentication authentication
    ) {

        Map<String,Object> params = new HashMap<>();
        params.put("receivedUser",getAuthUser(authentication).getId());
        PageHelper.startPage(page,size);
        List<ReferralVo> vos = referralService.list(params);
        PageInfo<ReferralVo> pageInfo = new PageInfo<>(vos);
        return resultGenerator.genSuccessResult(pageInfo);
    }
}
