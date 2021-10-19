package com.wanghuiwen.user.controller;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.model.UserFriend;
import com.wanghuiwen.user.service.UserFriendService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import io.swagger.annotations.*;



/**
* Created by wanghuiwen on 2021/10/19.
*/
@Api(value = "用户好友", tags = {"用户好友"})
@RestController
@RequestMapping("/user/friend")
public class UserFriendController extends Ctrl{
    @Resource
    private UserFriendService userFriendService;


    @ApiOperation(value = "用户好友添加", tags = {"用户好友"}, notes = "用户好友添加")
    @PostMapping(value="/apply",name="用户好友添加")
    public Result add(Long idolId, Authentication authentication) {
        userFriendService.apply(idolId,getAuthUser(authentication));
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户同意好友", tags = {"用户好友"}, notes = "用户同意好友")
    @PutMapping(value="/apply/agree",name="用户好友添加")
    public Result agree(Long id,Authentication authentication) {
        userFriendService.agree(id,getAuthUser(authentication));
        return resultGenerator.genSuccessResult();
    }
}
