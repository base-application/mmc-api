package com.wanghuiwen.user.queue;

import com.wanghuiwen.common.UtilFun;
import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class NotificationConsumer implements Runnable  {
    private final static Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);

    private NotificationQueueService notificationQueueService;

    public NotificationConsumer(NotificationQueueService notificationQueueService) {
        this.notificationQueueService = notificationQueueService;
    }

    @Override
    public void run() {
        while (true) {
            // 如果暂时没有过期消息或者队列为空，则take()方法会被阻塞，直到有过期的消息为止
            NotificationDelayedMessage delayMessage = notificationQueueService.getDelayQueue().poll();
            if(delayMessage!=null){
                LOGGER.info("发送通知  活动开始时间: {},当前时间 {}", new Date(delayMessage.getStartDate()) , DateUtils.formatDate(new Date(), UtilFun.YYYYMMDDHHMMSS));
                notificationQueueService.sendStareEvent(delayMessage);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
