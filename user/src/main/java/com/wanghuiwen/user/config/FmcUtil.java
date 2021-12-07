package com.wanghuiwen.user.config;

import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.wanghuiwen.base.model.User;
import com.wanghuiwen.user.service.UserInfoService;
import com.wanghuiwen.user.vo.MessageVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class FmcUtil {
    @Resource
    private UserInfoService userInfoService;

    public  void sendNotification(List<User> users, String title, String context, Map<String,String> data){
        List<Message> messages = new ArrayList<>();
        for (User user : users) {
            if(user.getPushId()!=null){
                MessageVo vo =userInfoService.message(user.getId());
                Message message = Message.builder()
                        .setNotification(
                                com.google.firebase.messaging.Notification.builder()
                                        .setBody(context)
                                        .setTitle(title)
                                        .build()
                        )
                        .setToken(user.getPushId())
                        .setApnsConfig(ApnsConfig.builder().setAps(Aps.builder().setBadge(vo.getCount()).build()).build())
                        .putAllData(data)
                        .build();
                messages.add(message);
            }
        }
        if(messages.size() > 0){
            FirebaseMessaging.getInstance().sendAllAsync(messages);
        }
    }

    public static void sendUser(String token, String title, String context, Map<String,String> data,int badge){
        Message message = Message.builder()
                .setNotification(
                        com.google.firebase.messaging.Notification.builder()
                                .setBody(context)
                                .setTitle(title)
                                .build()
                )
                .setToken(token)
                .setApnsConfig(ApnsConfig.builder().setAps(Aps.builder().setBadge(badge).build()).build())
                .putAllData(data)
                .build();
        FirebaseMessaging.getInstance().sendAsync(message);
    }


    public static void sendAll(String title, String context, Map<String,String> data){
        Message message = Message.builder()
                .setNotification(
                        com.google.firebase.messaging.Notification.builder()
                                .setBody(context)
                                .setTitle(title)
                                .build()
                )
                .setApnsConfig(ApnsConfig.builder().setAps(Aps.builder().setBadge(1).build()).build())
                .putAllData(data)
                .setTopic("mmc")
                .build();
        FirebaseMessaging.getInstance().sendAsync(message);
    }
}
