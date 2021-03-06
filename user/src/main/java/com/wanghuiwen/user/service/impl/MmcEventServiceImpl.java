package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.base.dao.UserMapper;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.core.ServiceException;
import com.wanghuiwen.core.config.AuthUser;
import com.wanghuiwen.core.response.Result;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.config.Const;
import com.wanghuiwen.user.dao.*;
import com.wanghuiwen.user.model.*;
import com.wanghuiwen.user.service.GradeService;
import com.wanghuiwen.user.service.MmcEventService;
import com.wanghuiwen.user.vo.AttendanceVo;
import com.wanghuiwen.user.vo.CheckLogVo;
import com.wanghuiwen.user.vo.EventVo;
import com.wanghuiwen.user.vo.EventVoAdd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    @Resource
    private EventUserReadMapper eventUserReadMapper;
    @Resource
    private ReferralPointLogMapper referralPointLogMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Long add(EventVoAdd add) {
        MmcEvent event = new MmcEvent();
        BeanUtils.copyProperties(add,event);
        event.setApproveStatus(Const.EVENT_WAITING);
        saveOrUpdate(event);


        eventPictureMapper.deleteByEvent(event.getEventId());

        if(!CollectionUtils.isEmpty(add.getEventPoster())){
            List<EventPicture> pictureList =  add.getEventPoster().stream().map(imageVo -> {
                EventPicture picture =  new EventPicture();
                picture.setEventId(event.getEventId());
                picture.setUrl(imageVo.getUrl());
                return picture;
            }).collect(Collectors.toList());
            eventPictureMapper.insertList(pictureList);
        }

        eventGroupMapper.deleteByEvent(event.getEventId());
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
        if(uid!=null){
            EventUserRead eventUserRead = new EventUserRead();
            eventUserRead.setEventId(id);
            eventUserRead.setUserId(uid);
            EventUserRead find =eventUserReadMapper.selectOne(eventUserRead);
            if(find==null){
                eventUserReadMapper.insertSelective(eventUserRead);
            }
        }
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
        long nh = 1000 * 60 * 60 * 2;// 2??????????????????
        MmcEvent event = findById(eventId);
        if(event.getEventStartTime() - new Date().getTime() > nh ) throw  new ServiceException("??????????????????????????????","user.40009");

        Attendance attendance = attendanceMapper.selectUserEvent(userId,eventId);


        if(attendance==null) throw  new ServiceException("?????????????????????","user.40004");
        if(attendance.getCheckInTime()!=null) throw  new ServiceException("??????????????????","user.40005");

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
        if(attendance!=null) throw new ServiceException("????????????????????????","user.40003");
        Attendance join = new Attendance();
        join.setUserId(userId);
        join.setEventId(eventId);
        join.setJoinTime(new Date().getTime());
        attendanceMapper.insert(join);
    }

    @Override
    public void unjoin(Long eventId, Long userId) {
        attendanceMapper.deleteUserEvent(eventId,userId);
    }

    @Override
    public void checkout(Long eventId, Long userId) {
        MmcEvent event =  findById(eventId);
        if(event.getEventStartTime() > new Date().getTime()) throw new ServiceException("???????????????????????????","user.40010");

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

    @Override
    public List<EventVoAdd> listUser(Map<String, Object> params) {
        return mmcEventMapper.listUser(params);
    }

    @Override
    public int count() {
        Condition where= new Condition(MmcEvent.class);
        return mmcEventMapper.selectCountByCondition(where);
    }

    @Override
    public void delete(Long id) {
        mmcEventMapper.updateDel(id);
    }

    @Override
    public void signedUp(Long id, Long userId) {
        Attendance attendance = attendanceMapper.selectUserEvent(userId,id);
        if(attendance.getSingedCourse()!=null) return;

        attendance.setSingedCourse(true);
        attendanceMapper.updateUserEvent(attendance);
        User user = userMapper.selectByPrimaryKey(userId);
        ///????????????
        if(user.getReferralId()!=null){
            User referralUser = userMapper.selectByPrimaryKey(user.getReferralId());
            MmcEvent mmcEvent = mmcEventMapper.selectByPrimaryKey(id);
            BigDecimal costomerPoint = mmcEvent.getPoint().multiply(new BigDecimal("0.5"));

            ReferralPointLog pointLog = new ReferralPointLog();
            pointLog.setCostomerId(userId);
            pointLog.setFooId(user.getReferralId());
            pointLog.setCreateTime(new Date().getTime());
            pointLog.setCostomerPoint(mmcEvent.getPoint());
            pointLog.setFooPoint(mmcEvent.getPoint());
            referralPointLogMapper.insert(pointLog);

            referralUser.setPoint(referralUser.getPoint().add(costomerPoint));
            userMapper.updateByPrimaryKeySelective(referralUser);
            user.setPoint(user.getPoint().add(costomerPoint));
            userMapper.updateByPrimaryKeySelective(user);
        }
    }
}
