package com.wanghuiwen.user.queue;

import com.wanghuiwen.base.model.User;
import com.wanghuiwen.user.config.FmcUtil;
import com.wanghuiwen.user.model.MmcEvent;
import com.wanghuiwen.user.service.MmcEventService;
import com.wanghuiwen.user.service.UserInfoService;
import com.wanghuiwen.user.vo.EventVo;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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
        fmcUtil.sendNotification(users,delayMessage.getNotificationTitle(), delayMessage.getNotificationContext(),delayMessage.getData());
    }

    public void  add(MmcEvent mmcEvent){
        if(DateUtils.addDays(new Date(mmcEvent.getEventStartTime()),-3).getTime() > new Date().getTime()){
            NotificationDelayedMessage message = new NotificationDelayedMessage();
            message.setStartDate(DateUtils.addDays(new Date(mmcEvent.getEventStartTime()),-3).getTime());
            message.setEventId(mmcEvent.getEventId());
            message.setId(UUID.randomUUID().toString());
            message.setNotificationContext(mmcEvent.getEventDescription());
            message.setNotificationTitle(mmcEvent.getEventTitle());
            this.offer(message);
        }

        if(DateUtils.addDays(new Date(mmcEvent.getEventStartTime()),-7).getTime() > new Date().getTime()){
            NotificationDelayedMessage message = new NotificationDelayedMessage();
            message.setStartDate(DateUtils.addDays(new Date(mmcEvent.getEventStartTime()),-7).getTime());
            message.setEventId(mmcEvent.getEventId());
            message.setId(UUID.randomUUID().toString());
            message.setNotificationContext(mmcEvent.getEventDescription());
            message.setNotificationTitle(mmcEvent.getEventTitle());
            this.offer(message);
        }
    }
}
