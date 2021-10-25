package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.model.ThankYouNote;
import com.wanghuiwen.user.service.ThankYouNoteService;
import com.wanghuiwen.user.vo.ThankYouAddVo;
import com.wanghuiwen.user.vo.ThankYouNoteVo;
import com.wanghuiwen.user.vo.UserInfoVo;
import io.swagger.annotations.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* Created by wanghuiwen on 2021/10/22.
*/
@Api(value = "感谢", tags = {"感谢"})
@RestController
@RequestMapping("/thank/you/note")
public class ThankYouNoteController extends Ctrl{
    @Resource
    private ThankYouNoteService thankYouNoteService;

    @ApiOperation(value = "用户发送感谢", tags = {"感谢"}, notes = "用户发送感谢")
    @PostMapping(value="/add",name="用户发送感谢")
    public Result add(@ApiParam ThankYouAddVo thankYouNote, Authentication authentication) {
        thankYouNote.setSender(getAuthUser(authentication).getId());
        thankYouNoteService.add(thankYouNote);
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "用户收到的感谢", tags = {"感谢"}, notes = "用户收到的感谢")
    @PostMapping(value="/user/list",name="用户收到的感谢")
    public Result userList(@RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "10") Integer size,
                           Authentication authentication) {
        Map<String,Object> params = new HashMap<>();
        params.put("receivedUser",getAuthUser(authentication).getId());
        PageHelper.startPage(page,size);
        List<ThankYouNoteVo> vos = thankYouNoteService.list(params);
        PageInfo<ThankYouNoteVo> pageInfo = new PageInfo<>(vos);
        return resultGenerator.genSuccessResult(pageInfo);
    }


    @ApiOperation(value = "感谢列表信息", tags = {"感谢"}, notes = "感谢列表信息")
    @PostMapping(value = "/list", name = "感谢列表信息")
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String groupId,
                       @RequestParam(required = false) String startTime,
                       @RequestParam(required = false) String endTime
                       ) {
        Map<String,Object> params = new HashMap<>();
        params.put("name",name);
        params.put("groupId",groupId);
        params.put("startTime",startTime);
        params.put("endTime",endTime);
        PageHelper.startPage(page,size);
         List<ThankYouNoteVo> vos = thankYouNoteService.list(params);
        PageInfo<ThankYouNoteVo> pageInfo = new PageInfo<>(vos);
        return resultGenerator.genSuccessResult(pageInfo);
    }
}
