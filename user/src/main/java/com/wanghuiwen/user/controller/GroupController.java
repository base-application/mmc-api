package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.model.MmcGroup;
import com.wanghuiwen.user.service.MmcGroupService;
import com.wanghuiwen.user.service.UserInfoService;
import com.wanghuiwen.user.vo.GroupUserVo;
import com.wanghuiwen.user.vo.UserNetWorkVo;
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
@Api(value = "用户分组", tags = {"用户分组"})
@RestController
@RequestMapping("/group")
public class GroupController extends Ctrl{
    @Resource
    private MmcGroupService mmcGroupService;
    @Resource
    private UserInfoService userInfoService;

    @ApiOperation(value = "用户分组添加", tags = {"用户分组"}, notes = "用户分组添加")
    @PutMapping(value="/add",name="用户分组添加")
    public Result add(@ApiParam MmcGroup group) {
        mmcGroupService.save(group);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户分组删除", tags = {"用户分组"}, notes = "用户分组删除")
    @DeleteMapping(value="/delete",name="用户分组删除")
    public Result delete(@RequestParam Long groupId) {
        mmcGroupService.deleteById(groupId);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户分组列表信息", tags = {"用户分组"}, notes = "用户分组列表信息")
    @GetMapping(value = "/list", name = "用户分组列表信息")
    public Result list() {
        return resultGenerator.genSuccessResult(mmcGroupService.findAll());
    }

    @ApiOperation(value = "用户端分组信息", tags = {"用户分组"}, notes = "用户端分组信息")
    @GetMapping(value = "/list/user", name = "用户端分组信息")
    public Result userList() {
        List<GroupUserVo> userVos =  mmcGroupService.listUser();
        return resultGenerator.genSuccessResult(userVos);
    }

    @ApiOperation(value = "根据分组获取用户", tags = {"用户分组"}, notes = "根据分组获取用户")
    @GetMapping(value = "/user", name = "根据分组获取用户")
    public Result user(@RequestParam Long groupId, Authentication authentication) {
        Map<String,Object> params = new HashMap<>();
        params.put("groupId",groupId);
        params.put("userId",getAuthUser(authentication).getId());
        List<UserNetWorkVo> netWorkVos = userInfoService.network(params);
        return resultGenerator.genSuccessResult(netWorkVos);
    }
}
