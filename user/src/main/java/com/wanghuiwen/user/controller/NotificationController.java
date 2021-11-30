package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.config.Const;
import com.wanghuiwen.user.config.FmcUtil;
import com.wanghuiwen.user.model.Notification;
import com.wanghuiwen.user.service.NotificationService;
import com.wanghuiwen.user.service.UserInfoService;
import com.wanghuiwen.user.vo.NotificationType;
import com.wanghuiwen.user.vo.NotificationUserListVo;
import com.wanghuiwen.user.vo.NotificationVo;
import io.swagger.annotations.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;


/**
* Created by wanghuiwen on 2021/10/22.
*/
@Api(value = "通知", tags = {"通知"})
@RestController
@RequestMapping("/notification")
public class NotificationController extends Ctrl{
    @Resource
    private NotificationService notificationService;
    @Resource
    private UserInfoService userInfoService;

    @ApiOperation(value = "通知添加", tags = {"通知"}, notes = "通知添加")
    @PostMapping(value="/add",name="通知添加")
    public Result add(@RequestBody NotificationVo notification, Authentication authentication) {
        notification.setCreateId(getAuthUser(authentication).getId());
        notification.setNotificationTime(new Date().getTime());
        notificationService.add(notification);
        List<User> users = userInfoService.findByGroupAndGrade(notification.getGroups(),notification.getGrades());

        FmcUtil.sendNotification(users,notification.getNotificationTitle(),Const.REGEX_HTML.matcher(notification.getNotificationContent()).replaceAll(""),null);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "通知删除", tags = {"通知"}, notes = "通知删除")
    @DeleteMapping(value="/delete",name="通知删除")
    public Result delete(@RequestParam Long id) {
        notificationService.deleteById(id);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "通知详细信息", tags = {"通知"}, notes = "通知详细信息")
    @PostMapping(value="/detail",name="通知详细信息")
    public Result detail(@RequestParam Integer id) {
        Notification notification = notificationService.findById(id);
        return resultGenerator.genSuccessResult(notification);
    }

    @ApiOperation(value = "通知列表信息", tags = {"通知"}, notes = "通知列表信息")
    @GetMapping(value = "/list", name = "通知列表信息")
    public Result list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer groupId,
            @RequestParam(required = false) Integer startTime,
            @RequestParam(required = false) Integer endTime

    ) {
        Map<String,Object> params = new HashMap<>();
        params.put("title",title);
        params.put("groupId",groupId);
        params.put("startTime",startTime);
        params.put("endTime",endTime);
        PageHelper.startPage(page,size);
        List<NotificationVo> vos = notificationService.list(params);
        PageInfo<NotificationVo> pageInfo = new PageInfo<>(vos);
        return resultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "通知列表信息", tags = {"通知"}, notes = "通知列表信息")
    @GetMapping(value = "/user/list", name = "通知列表信息")
    public Result userList(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            Authentication authentication
    ) {
        Map<String,Object> params = new HashMap<>();
        params.put("userId",getAuthUser(authentication).getId());
        PageHelper.startPage(page,size);
        List<NotificationUserListVo> vos = notificationService.userList(params);
        PageInfo<NotificationUserListVo> pageInfo = new PageInfo<>(vos);
        return resultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "通知详细信息", tags = {"通知"}, notes = "通知详细信息")
    @PutMapping(value="/read",name="通知详细信息")
    public Result read(@RequestParam Long notificationId,Authentication authentication) {
        notificationService.read(notificationId,getAuthUser(authentication).getId());
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户删除通知", tags = {"通知"}, notes = "用户删除通知")
    @PutMapping(value="/user/delete",name="用户删除通知")
    public Result userDelete(@RequestBody Long[] notificationId,Authentication authentication) {
        notificationService.userDelete(notificationId,getAuthUser(authentication).getId());
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "通知类型", tags = {"通知"}, notes = "通知类型")
    @GetMapping(value="/type/list",name="通知类型")
    public Result types() {
        List<NotificationType> types = new ArrayList<>();
        String[] typeName = {"Loan genie","Property deal","News","Updates","System"};
        for (int i = 0; i < typeName.length; i++) {
            NotificationType type = new NotificationType();
            type.setId(i);
            type.setName(typeName[i]);
            types.add(type);
        }
        return resultGenerator.genSuccessResult(types);
    }
}
