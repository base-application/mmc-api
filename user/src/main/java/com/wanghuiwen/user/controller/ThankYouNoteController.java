package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.base.service.UserService;
import com.wanghuiwen.common.mybatis.ResultMap;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.config.FmcUtil;
import com.wanghuiwen.user.model.Referral;
import com.wanghuiwen.user.model.ThankYouNote;
import com.wanghuiwen.user.service.ReferralService;
import com.wanghuiwen.user.service.ThankYouNoteService;
import com.wanghuiwen.user.service.UserInfoService;
import com.wanghuiwen.user.vo.ThankYouAddVo;
import com.wanghuiwen.user.vo.ThankYouNoteVo;
import com.wanghuiwen.user.vo.UserInfoVo;
import io.swagger.annotations.*;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    private UserService userService;
    @Resource
    private MessageSource messageSource;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private ReferralService referralService;

    @ApiOperation(value = "用户发送感谢", tags = {"感谢"}, notes = "用户发送感谢")
    @PostMapping(value="/add",name="用户发送感谢")
    public Result add(@RequestBody ThankYouAddVo thankYouNote, Authentication authentication) {
        thankYouNote.setSender(getAuthUser(authentication).getId());
        Referral referral = referralService.findById(thankYouNote.getReferralId());
        User user = userService.findById(referral.getSendUser());
        thankYouNoteService.add(thankYouNote);
        if(user.getPushId()!=null){
            String message = messageSource.getMessage("thank.send", null, LocaleContextHolder.getLocale());
            FmcUtil.sendUser(user.getPushId(),"Thank You",message,new HashMap<>(),userInfoService.message(user.getId()).getCount());
        }
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "用户收到的感谢", tags = {"感谢"}, notes = "用户收到的感谢")
    @GetMapping(value="/user/list",name="用户收到的感谢")
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
    @GetMapping(value = "/list", name = "感谢列表信息")
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
        Map<String,Object> res = new HashMap<>();
        PageHelper.startPage(page,size);
         List<ThankYouNoteVo> vos = thankYouNoteService.list(params);
        PageInfo<ThankYouNoteVo> pageInfo = new PageInfo<>(vos);
        res.put("list",pageInfo);
        res.put("total",thankYouNoteService.sum(params));
        return resultGenerator.genSuccessResult(res);
    }
}
