package com.wanghuiwen.user.controller;

import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.service.UserFollowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;



/**
* Created by wanghuiwen on 2021/11/19.
*/
@Api(value = "用户管理", tags = {"用户管理"})
@RestController
@RequestMapping("/user/follow")
public class UserFollowController extends Ctrl{
    @Resource
    private UserFollowService userFollowService;

    @ApiOperation(value = "关注/取消", tags = {"用户管理"}, notes = "关注/取消")
    @PostMapping(value="/add",name="关注/取消")
    public Result add(Long userId , Authentication authentication) {
        userFollowService.follow(userId,getAuthUser(authentication).getId());
        return resultGenerator.genSuccessResult();
    }
}
