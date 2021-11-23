package com.wanghuiwen.user.config;

import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.wanghuiwen.base.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FmcUtil {
    public static void sendNotification(List<User> users, String title, String context, Map<String,String> data){
        List<Message> messages = new ArrayList<>();
        for (User user : users) {
            if(user.getPushId()!=null){
                Message message = Message.builder()
                        .setNotification(
                                com.google.firebase.messaging.Notification.builder()
                                        .setBody(context)
                                        .setTitle(title)
                                        .build()
                        )
                        .setToken(user.getPushId())
                        .setApnsConfig(ApnsConfig.builder().setAps(Aps.builder().setBadge(1).build()).build())
                        .putAllData(data)
                        .build();
                messages.add(message);
            }
        }
        if(messages.size() > 0){
            FirebaseMessaging.getInstance().sendAllAsync(messages);
        }
    }

    public static void sendUser(String token, String title, String context, Map<String,String> data){
        Message message = Message.builder()
                .setNotification(
                        com.google.firebase.messaging.Notification.builder()
                                .setBody(context)
                                .setTitle(title)
                                .build()
                )
                .setToken(token)
                .setApnsConfig(ApnsConfig.builder().setAps(Aps.builder().setBadge(1).build()).build())
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
                .build();
        FirebaseMessaging.getInstance().sendAsync(message);
    }
}
