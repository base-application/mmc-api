package com.wanghuiwen.user.message;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

public class FirebaseMessage {

    public void  send() throws FirebaseMessagingException {
        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle("From Wayne's Talk")
                        .setBody("Hello Wayns's Talk")
                        .build())
                .putData("payload1", "data1")
                .putData("payload2", "data2")
                .setToken("")
                .build();
        FirebaseMessaging.getInstance().send(message);
        FirebaseMessaging.getInstance().sendAsync(message);
//        FirebaseMessaging.getInstance().sendMulticastAsync(message);
    }
}
