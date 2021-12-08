package com.wanghuiwen.user.queue;

import com.wanghuiwen.base.model.User;
import com.wanghuiwen.user.config.FmcUtil;
import com.wanghuiwen.user.model.MmcEvent;
import com.wanghuiwen.user.model.Referral;
import com.wanghuiwen.user.service.MmcEventService;
import com.wanghuiwen.user.service.ReferralService;
import com.wanghuiwen.user.service.UserInfoService;
import com.wanghuiwen.user.vo.EventVo;
import com.wanghuiwen.user.vo.ReferralAddVo;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.DelayQueue;

@Component
public class NotificationQueueService {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    private DelayQueue<NotificationDelayedMessage> delayQueue = new DelayQueue<>();

    public DelayQueue<NotificationDelayedMessage> getDelayQueue() {
        return delayQueue;
    }

    @Resource
    private MmcEventService mmcEventService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private  FmcUtil fmcUtil;
    @Resource
    private MessageSource messageSource;
    @Resource
    private ReferralService referralService;


    public void offer(NotificationDelayedMessage delayMessage){
        delayQueue.offer(delayMessage);
        logger.info("队列添加消息 执行时间: {}, 队列长度 {}" , new Date(delayMessage.getStartDate()), delayQueue.size());

    }

    public void remove(NotificationDelayedMessage delayMessage){
        boolean isRemove = delayQueue.remove(delayMessage);
        logger.info("队列删除消息: {}, 队列长度 {}" ,isRemove, delayQueue.size());
    }

    @PostConstruct
    private void init() {
        logger.info("活动队列初始化 3天后的活动加入队列中");
        List<MmcEvent> mmcEvents = mmcEventService.findByStartDate();
        for (MmcEvent mmcEvent : mmcEvents) {
            add(mmcEvent);
        }
        logger.info("活动队列初始化"+mmcEvents.size() + "条活动加入队列");

        logger.info("活动队列初始化 未联系的referral加入队列");
        List<Referral> referral = referralService.findByNoThank();
        for (Referral referral1 : referral) {
            addReferral(referral1);
        }
        logger.info("活动队列初始化 "+ referral.size() +"条未联系的referral加入队列");
        //每次启动 未开始的赛事加入队列
        new Thread(new NotificationConsumer(this)).start();
    }

    /**
     * 发送通知
     * @param delayMessage
     */
    public void sendStareEvent(NotificationDelayedMessage delayMessage) {
        EventVo event = mmcEventService.detail(delayMessage.getEventId(),null);
        List<User> users =userInfoService.findByGroupAndGrade(event.getGroups(),event.getGrades());
        SimpleDateFormat format = new SimpleDateFormat("hh.a, dd MM yyyy",LocaleContextHolder.getLocale());
        String dateString = format.format(new Date(delayMessage.getStartDate()));
        if(delayMessage.getType() == 1){
            String message = messageSource.getMessage("notification.remind", new String[]{dateString}, LocaleContextHolder.getLocale());
            fmcUtil.sendNotification(users,delayMessage.getNotificationTitle(), message,delayMessage.getData());
        }
        if(delayMessage.getType() == 2){
           Referral referral = referralService.findById(delayMessage.getEventId());
           if(referral!=null && !referral.getThank()){
               String message = messageSource.getMessage("referral.received", new String[]{dateString}, LocaleContextHolder.getLocale());
               fmcUtil.sendNotification(users,delayMessage.getNotificationTitle(), message,delayMessage.getData());
           }
        }
    }

    /**
     * 活动前7天推送有活动要记得出席
     * 活动前3天推送有活动要记得出席
     * 活动要开始的1小时前要记得出席
     * @param mmcEvent
     */
    public void  add(MmcEvent mmcEvent){

        if(DateUtils.addDays(new Date(mmcEvent.getEventStartTime()),-3).getTime() > new Date().getTime()){
            NotificationDelayedMessage message = new NotificationDelayedMessage();
            message.setStartDate(DateUtils.addDays(new Date(mmcEvent.getEventStartTime()),-3).getTime());
            message.setEventId(mmcEvent.getEventId());
            message.setId(UUID.randomUUID().toString());
            message.setNotificationContext(mmcEvent.getEventDescription());
            message.setNotificationTitle(mmcEvent.getEventTitle());
            message.setType(1);
            this.offer(message);
        }

        if(DateUtils.addDays(new Date(mmcEvent.getEventStartTime()),-7).getTime() > new Date().getTime()){
            NotificationDelayedMessage message = new NotificationDelayedMessage();
            message.setStartDate(DateUtils.addDays(new Date(mmcEvent.getEventStartTime()),-7).getTime());
            message.setEventId(mmcEvent.getEventId());
            message.setId(UUID.randomUUID().toString());
            message.setNotificationContext(mmcEvent.getEventDescription());
            message.setNotificationTitle(mmcEvent.getEventTitle());
            message.setType(1);
            this.offer(message);
        }

        if(DateUtils.addHours(new Date(mmcEvent.getEventStartTime()),-1).getTime() > new Date().getTime()){
            NotificationDelayedMessage message = new NotificationDelayedMessage();
            message.setStartDate(DateUtils.addHours(new Date(mmcEvent.getEventStartTime()),-1).getTime());
            message.setEventId(mmcEvent.getEventId());
            message.setId(UUID.randomUUID().toString());
            message.setNotificationContext(mmcEvent.getEventDescription());
            message.setNotificationTitle(mmcEvent.getEventTitle());
            message.setType(1);
            this.offer(message);
        }
    }

    /**
     * Referral如果过了1星期还没点击contacted要发推送询问近况
     * @param referral
     */
    public void addReferral(Referral referral){
        if(DateUtils.addDays(new Date(referral.getSendTime()),-7).getTime() > new Date().getTime()){
            NotificationDelayedMessage message = new NotificationDelayedMessage();
            message.setStartDate(DateUtils.addDays(new Date(referral.getSendTime()),-7).getTime());
            message.setEventId(referral.getReferralId());
            message.setId(UUID.randomUUID().toString());
            message.setNotificationTitle("Master Mind Council");
            message.setType(2);
            this.offer(message);
        }
    }
}
