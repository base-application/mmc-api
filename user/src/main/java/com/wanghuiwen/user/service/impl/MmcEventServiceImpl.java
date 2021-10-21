package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.config.Const;
import com.wanghuiwen.user.dao.AttendanceMapper;
import com.wanghuiwen.user.dao.EventGroupMapper;
import com.wanghuiwen.user.dao.EventPictureMapper;
import com.wanghuiwen.user.dao.MmcEventMapper;
import com.wanghuiwen.user.model.Attendance;
import com.wanghuiwen.user.model.EventGroup;
import com.wanghuiwen.user.model.EventPicture;
import com.wanghuiwen.user.model.MmcEvent;
import com.wanghuiwen.user.service.MmcEventService;
import com.wanghuiwen.user.vo.CheckHistoryVo;
import com.wanghuiwen.user.vo.EventVo;
import com.wanghuiwen.user.vo.EventVoAdd;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class MmcEventServiceImpl extends AbstractService<MmcEvent> implements MmcEventService {
    @Resource
    private MmcEventMapper mmcEventMapper;
    @Resource
    private EventPictureMapper eventPictureMapper;

    @Resource
    private EventGroupMapper eventGroupMapper;
    @Resource
    private AttendanceMapper attendanceMapper;

    @Override
    public void add(EventVoAdd add) {
        MmcEvent event = new MmcEvent();
        BeanUtils.copyProperties(add,event);
        event.setApproveStatus(Const.EVENT_WAITING);
        saveOrUpdate(event);

        eventPictureMapper.deleteByEvent(event.getEventId());
        eventGroupMapper.deleteByEvent(event.getEventId());

        List<EventPicture> pictureList =  add.getEventPoster().stream().map(imageVo -> {
            EventPicture picture =  new EventPicture();
            picture.setEventId(event.getEventId());
            picture.setUrl(imageVo.getUrl());
            return picture;
        }).collect(Collectors.toList());
        eventPictureMapper.insertList(pictureList);

        List<EventGroup> groups =  add.getGroups().stream().map(group -> {
            EventGroup picture =  new EventGroup();
            picture.setEventId(event.getEventId());
            picture.setGroupId(group.getGroupId());
            return picture;
        }).collect(Collectors.toList());
        eventGroupMapper.insertList(groups);

    }

    @Override
    public void approve(Long eventId, Integer approveStatus) {
        MmcEvent event = findById(eventId);
        event.setApproveStatus(approveStatus);
        update(event);
    }

    @Override
    public EventVo detail(Integer id) {

        return mmcEventMapper.detail(id);
    }

    @Override
    public List<EventVoAdd> list(Map<String, Object> params) {
        return mmcEventMapper.list(params);
    }

    @Override
    public void checkinConfirm(Long userId, Long eventId, Boolean isAttendance) {
        Attendance attendance = attendanceMapper.selectUserEvent(userId,eventId);
        attendance.setIsAttendance(isAttendance);
        attendanceMapper.updateUserEvent(attendance);
    }

    @Override
    public void checkin(Long eventId, Long userId) {
        Attendance attendance = attendanceMapper.selectUserEvent(userId,eventId);
        attendance.setIsAttendance(true);
        attendance.setCheckInTime(new Date().getTime());
        attendanceMapper.updateUserEvent(attendance);
    }

    @Override
    public void join(Long eventId, Long userId) {
        Attendance attendance = attendanceMapper.selectUserEvent(userId,eventId);
        if(attendance!=null) throw new ServiceException("用户已经加入活动");
        Attendance join = new Attendance();
        join.setUserId(userId);
        join.setEventId(eventId);
        attendanceMapper.insert(join);
    }

    @Override
    public void unjoin(Long eventId, Long userId) {
        attendanceMapper.deleteUserEvent(eventId,userId);
    }

    @Override
    public void checkout(Long eventId, Long userId) {
        Attendance attendance = attendanceMapper.selectUserEvent(userId,eventId);
        attendance.setCheckOutTime(new Date().getTime());
        attendanceMapper.updateUserEvent(attendance);
    }

    @Override
    public void confirmAttend(Long eventId, Long userId, String agent, String agentRole, String absentReason) {
        Attendance attendance = attendanceMapper.selectUserEvent(userId,eventId);
        attendance.setIsAttendance(true);
        attendance.setAgent(agent);
        attendance.setAgentRole(agentRole);
        attendance.setAbsentReason(absentReason);
        attendanceMapper.updateUserEvent(attendance);
    }

    @Override
    public List<CheckHistoryVo> checkHistory(Long id) {

        return attendanceMapper.checkHistory(id);
    }

    @Override
    public void facebookComment(Long eventId, Long userId, Boolean facebookComment) {
        Attendance attendance = attendanceMapper.selectUserEvent(userId,eventId);
        attendance.setFacebookComment(facebookComment);
        attendanceMapper.updateUserEvent(attendance);
    }

    @Override
    public List<EventVoAdd> upcomingEvent(AuthUser user) {
        return mmcEventMapper.upcomingEvent(user.getId());
    }

    @Override
    public List<EventVoAdd> joinList(AuthUser authUser) {
        return mmcEventMapper.joinList(authUser.getId());
    }

    @Override
    public List<EventVoAdd> userCreate(AuthUser authUser) {
        return mmcEventMapper.userCreate(authUser.getId());
    }
}
