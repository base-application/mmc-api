package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.base.service.UserService;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.config.FmcUtil;
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
    @Resource
    private UserService userService;

    @ApiOperation(value = "发送推荐", tags = {"推荐"}, notes = "发送推荐")
    @PostMapping(value="/send",name="发送推荐")
    public Result add(@RequestBody ReferralAddVo addVo,Authentication authentication) {
        referralService.send(addVo,getAuthUser(authentication).getId());
        User user = userService.findById(addVo.getReceivedUser());
        if(user.getPushId()!=null){
            FmcUtil.sendUser(user.getPushId(),"推荐","有朋友推荐给你",null);
        }
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
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long startTime,
            @RequestParam(required = false) Long endTime,
            @RequestParam(required = false) Long groupId
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

    @ApiOperation(value = "添加备注", tags = {"推荐"}, notes = "添加备注")
    @PutMapping(value="/remark",name="添加备注")
    public Result remark(
            @RequestParam Long referralId,
            @RequestParam String remark
    ) {
        referralService.remark(referralId,remark);
        return resultGenerator.genSuccessResult();
    }
}
