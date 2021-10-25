package com.wanghuiwen.user.service.impl;

import com.wanghuiwen.user.config.Const;
import com.wanghuiwen.user.dao.NotificationGradeMapper;
import com.wanghuiwen.user.dao.NotificationGroupMapper;
import com.wanghuiwen.user.dao.NotificationMapper;
import com.wanghuiwen.user.dao.NotificationUserMapper;
import com.wanghuiwen.user.model.Notification;
import com.wanghuiwen.user.model.NotificationGrade;
import com.wanghuiwen.user.model.NotificationGroup;
import com.wanghuiwen.user.model.NotificationUser;
import com.wanghuiwen.user.service.NotificationService;
import com.wanghuiwen.core.service.AbstractService;
import com.wanghuiwen.user.vo.NotificationUserListVo;
import com.wanghuiwen.user.vo.NotificationVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by wanghuiwen on 2021/10/18.
 */
@Service
@Transactional
public class NotificationServiceImpl extends AbstractService<Notification> implements NotificationService {
    @Resource
    private NotificationMapper notificationMapper;
    @Resource
    private NotificationGradeMapper notificationGradeMapper;
    @Resource
    private NotificationGroupMapper notificationGroupMapper;
    @Resource
    private NotificationUserMapper notificationUserMapper;

    @Override
    public void add(NotificationVo notificationVo) {
        Notification notification = new Notification();
        BeanUtils.copyProperties(notificationVo,notification);
        saveOrUpdate(notification);

        notificationGradeMapper.deleteByNotification(notification.getNotificationId());
        List<NotificationGrade> grades = notificationVo.getGrades().stream().map(grade -> {
            NotificationGrade notificationGrade = new NotificationGrade();
            notificationGrade.setGradeId(grade.getGradeId());
            notificationGrade.setNotificationId(notification.getNotificationId());
            return notificationGrade;
        }).collect(Collectors.toList());
        notificationGradeMapper.insertList(grades);


        notificationGroupMapper.deleteByNotification(notification.getNotificationId());
        List<NotificationGroup> groups =  notificationVo.getGroups().stream().map(g -> {
            NotificationGroup group = new NotificationGroup();
            group.setGroupId(g.getGroupId());
            group.setNotificationId(notificationVo.getNotificationId());
            return group;
        }).collect(Collectors.toList());
        notificationGroupMapper.insertList(groups);

    }

    @Override
    public List<NotificationVo> list(Map<String, Object> params) {

        return notificationMapper.list(params);
    }

    @Override
    public List<NotificationUserListVo> userList(Map<String, Object> params) {
        return notificationMapper.userList(params);
    }

    @Override
    public void read(Integer notificationId, Long userId) {

       NotificationUser notificationUser =  notificationUserMapper.selectByUser(notificationId,userId);
       if(notificationUser==null){
           NotificationUser read = new NotificationUser();
           read.setNotificationId(notificationId);
           read.setStatus(Const.NOTIFICATION_READ);
           read.setUserId(userId);
           notificationUserMapper.insertSelective(read);
       }
    }

    @Override
    public void userDelete(Integer notificationId, Long userId) {
        NotificationUser notificationUser =  notificationUserMapper.selectByUser(notificationId,userId);
        notificationUser.setStatus(Const.NOTIFICATION__DELETE);
        notificationUserMapper.updateByUser(notificationUser);
    }
}
