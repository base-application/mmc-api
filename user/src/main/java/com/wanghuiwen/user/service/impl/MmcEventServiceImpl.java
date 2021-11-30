package com.wanghuiwen.user.service.impl;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.config.Const;
import com.wanghuiwen.user.dao.*;
import com.wanghuiwen.user.model.*;
import com.wanghuiwen.user.service.GradeService;
import com.wanghuiwen.user.service.MmcEventService;
import com.wanghuiwen.user.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private MmcEventMapper mmcEventMapper;
    @Resource
    private EventPictureMapper eventPictureMapper;

    @Resource
    private EventGroupMapper eventGroupMapper;
    @Resource
    private AttendanceMapper attendanceMapper;
    @Resource
    private GradeService gradeService;
    @Resource
    private EventGradeMapper eventGradeMapper;
    @Resource
    private CheckLogMapper checkLogMapper;

    @Override
    public Long add(EventVoAdd add) {
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

        if(!CollectionUtils.isEmpty( add.getGroups())){
            List<EventGroup> groups =  add.getGroups().stream().map(group -> {
                EventGroup eventGroup =  new EventGroup();
                eventGroup.setEventId(event.getEventId());
                eventGroup.setGroupId(group.getGroupId());
                return eventGroup;
            }).collect(Collectors.toList());
            eventGroupMapper.insertListNoAuto(groups);
        }


        gradeService.deleteByEvent(event.getEventId());
        if(!CollectionUtils.isEmpty(add.getGrades())){
            List<EventGrade> grades = add.getGrades().stream().map(grade -> {
                EventGrade eventGrade = new EventGrade();
                eventGrade.setEventId(event.getEventId());
                eventGrade.setGradeId(grade.getGradeId());
                return  eventGrade;
            }).collect(Collectors.toList());
            eventGradeMapper.insertListNoAuto(grades);
        }
        return event.getEventId();
    }

    @Override
    public void approve(Long eventId, Integer approveStatus) {
        MmcEvent event = findById(eventId);
        event.setApproveStatus(approveStatus);
        update(event);
    }

    @Override
    public EventVo detail(Long id, Long uid) {
        return mmcEventMapper.detail(id,uid);
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
        if(attendance==null) throw  new ServiceException("用户未加入活动","user.40004");
        if(attendance.getCheckInTime()!=null) throw  new ServiceException("用户已经签到","user.40005");
        attendance.setIsAttendance(true);
        attendance.setCheckInTime(new Date().getTime());
        attendanceMapper.updateUserEvent(attendance);
        CheckLog log = new CheckLog();
        log.setCheckType(1);
        log.setCreateTime(new Date().getTime());
        log.setEventId(eventId);
        log.setUserId(userId);
        checkLogMapper.insertSelective(log);

    }

    @Override
    public void join(Long eventId, Long userId) {
        Attendance attendance = attendanceMapper.selectUserEvent(userId,eventId);
        if(attendance!=null) throw new ServiceException("用户已经加入活动","user.40003");
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

        CheckLog log = new CheckLog();
        log.setCheckType(2);
        log.setCreateTime(new Date().getTime());
        log.setEventId(eventId);
        log.setUserId(userId);
        checkLogMapper.insertSelective(log);
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
    public List<CheckLogVo> checkHistory(Long id) {

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
    public List<EventVoAdd> userCreate(AuthUser authUser, Map<String, Object> params) {
        return mmcEventMapper.userCreate(authUser.getId(),params);
    }

    @Override
    public List<AttendanceVo> getAttendance(Long id, Long groupId, Long startTime, Long endTime) {
        return mmcEventMapper.getAttendance(id,groupId,startTime,endTime);
    }

    @Override
    public List<MmcEvent> findByStartDate() {
        return mmcEventMapper.findByStartDate();
    }
}
