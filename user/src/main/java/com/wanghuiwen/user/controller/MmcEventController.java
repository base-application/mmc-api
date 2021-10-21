package com.wanghuiwen.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuiwen.core.controller.Ctrl;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.user.service.MmcEventService;
import com.wanghuiwen.user.vo.CheckHistoryVo;
import com.wanghuiwen.user.vo.EventVo;
import com.wanghuiwen.user.vo.EventVoAdd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* Created by wanghuiwen on 2021/10/20.
*/
@Api(value = "活动", tags = {"活动"})
@RestController
@RequestMapping("/event")
public class MmcEventController extends Ctrl{
    @Resource
    private MmcEventService mmcEventService;

    @ApiOperation(value = "活动添加", tags = {"活动"}, notes = "活动添加")
    @PostMapping(value="/add",name="活动添加")
    public Result add(@ApiParam EventVoAdd add) {
        mmcEventService.add(add);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "审核活动", tags = {"活动"}, notes = "审核活动")
    @PutMapping(value="/approve",name="审核活动")
    public Result approve(Long eventId,Integer approveStatus) {
        mmcEventService.approve(eventId,approveStatus);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "活动详情", tags = {"活动"}, notes = "活动详情")
    @PostMapping(value="/detail",name="活动详情")
    public Result detail(@RequestParam Integer id) {
        EventVo vo = mmcEventService.detail(id);
        return resultGenerator.genSuccessResult(vo);
    }

    @ApiOperation(value = "活动列表信息", tags = {"活动"}, notes = "活动列表信息")
    @PostMapping(value = "/list", name = "活动列表信息")
    public Result list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam String eventTitle,
            @RequestParam Long groupId,
            @RequestParam Long startTime,
            @RequestParam Long endTime
    ) {
        Map<String,Object> params = new HashMap<>();
        params.put("eventTitle",eventTitle);
        params.put("groupId",groupId);
        params.put("startTime",startTime);
        params.put("endTime",endTime);
        PageHelper.startPage(page,size);
        List<EventVoAdd> res =mmcEventService.list(params);
        PageInfo<EventVoAdd> pageInfo = new PageInfo<>(res);
        return resultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "管理员修改签到状态", tags = {"活动"}, notes = "管理员修改签到状态")
    @PutMapping(value="/attendance/checkin/confirm",name="管理员修改签到状态")
    public Result checkinConfirm(
            @RequestParam Long userId,
            @RequestParam Long eventId,
            @RequestParam Boolean isAttendance
    ) {
        mmcEventService.checkinConfirm(userId,eventId,isAttendance);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户签到", tags = {"活动"}, notes = "用户签到")
    @PutMapping(value="/checkin",name="用户签到")
    public Result checkin(
            @RequestParam Long eventId,
            Authentication authentication
    ) {
        mmcEventService.checkin(eventId,getAuthUser(authentication).getId());
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "签退", tags = {"活动"}, notes = "签退")
    @PutMapping(value="/checkout",name="签退")
    public Result checkout(
            @RequestParam Long eventId,
            Authentication authentication
    ) {
        mmcEventService.checkout(eventId,getAuthUser(authentication).getId());
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "确认出席人", tags = {"活动"}, notes = "确认出席人")
    @PutMapping(value="confirm/attend",name="确认出席人")
    public Result confirmAttend(
            @RequestParam Long eventId,
            @RequestParam Long userId,
            @RequestParam String agent,
            @RequestParam String agentRole,
            @RequestParam String absentReason
    ) {
        mmcEventService.confirmAttend(eventId,userId,agent,agentRole,absentReason);
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户签到历史", tags = {"活动"}, notes = "用户签到历史")
    @GetMapping(value = "/check/history", name = "用户签到历史")
    public Result checkHistory(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            Authentication authentication) {
        PageHelper.startPage(page,size);
        List<CheckHistoryVo> res =mmcEventService.checkHistory(getAuthUser(authentication).getId());
        PageInfo<CheckHistoryVo> pageInfo = new PageInfo<>(res);
        return resultGenerator.genSuccessResult(pageInfo);
    }


    @ApiOperation(value = "用户加入活动", tags = {"活动"}, notes = "用户加入活动")
    @PutMapping(value="/join",name="用户加入活动")
    public Result join(
            @RequestParam Long eventId,
            Authentication authentication
    ) {
        mmcEventService.join(eventId,getAuthUser(authentication).getId());
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户退出活动", tags = {"活动"}, notes = "用户退出活动")
    @PutMapping(value="/unjoin",name="用户退出活动")
    public Result unjoin(
            @RequestParam Long eventId,
            Authentication authentication
    ) {
        mmcEventService.unjoin(eventId,getAuthUser(authentication).getId());
        return resultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "标记用户是否留言", tags = {"活动"}, notes = "标记用户是否留言")
    @PutMapping(value="/facebook/comment",name="标记用户是否留言")
    public Result facebookComment(
            @RequestParam Long eventId,
            @RequestParam Long userId,
            @RequestParam Boolean facebookComment
    ) {
        mmcEventService.facebookComment(eventId,userId,facebookComment);
        return resultGenerator.genSuccessResult();
    }


    @ApiOperation(value = "用户端-活动列表", tags = {"活动"}, notes = "用户端-活动列表")
    @GetMapping(value = "/list/user", name = "用户端-活动列表")
    public Result listUser(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam Long startTime,
            @RequestParam Long endTime
    ) {
        Map<String,Object> params = new HashMap<>();
        params.put("startTime",startTime);
        params.put("endTime",endTime);
        PageHelper.startPage(page,size);
        List<EventVoAdd> res =mmcEventService.list(params);
        PageInfo<EventVoAdd> pageInfo = new PageInfo<>(res);
        return resultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "Upcoming Event", tags = {"活动"}, notes = "Upcoming Event")
    @GetMapping(value = "/upcoming", name = "Upcoming Event")
    public Result upcomingEvent(  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer size,
                                  Authentication authentication) {
        PageHelper.startPage(page,size);
        List<EventVoAdd> res =mmcEventService.upcomingEvent(getAuthUser(authentication));
        PageInfo<EventVoAdd> pageInfo = new PageInfo<>(res);
        return resultGenerator.genSuccessResult(pageInfo);
    }


    @ApiOperation(value = "用户加入的活动", tags = {"活动"}, notes = "用户加入的活动")
    @GetMapping(value = "/join/list", name = "用户加入的活动")
    public Result joinList(  @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer size,
                             Authentication authentication) {
        PageHelper.startPage(page,size);
        List<EventVoAdd> res =mmcEventService.joinList(getAuthUser(authentication));
        PageInfo<EventVoAdd> pageInfo = new PageInfo<>(res);
        return resultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "用户创建的活动", tags = {"活动"}, notes = "用户创建的活动")
    @GetMapping(value = "/user/create", name = "用户创建的活动")
    public Result userCreate(  @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer size,
                             Authentication authentication) {
        PageHelper.startPage(page,size);
        List<EventVoAdd> res =mmcEventService.userCreate(getAuthUser(authentication));
        PageInfo<EventVoAdd> pageInfo = new PageInfo<>(res);
        return resultGenerator.genSuccessResult(pageInfo);
    }
}
