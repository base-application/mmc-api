package com.wanghuiwen.user.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import java.io.InputStream;

@Configuration
public class FcmInitialization implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("初始化 firebase ");
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        InputStream certStream = resourceLoader.getResource("mastermind-3360d-firebase-adminsdk-bzpp8-17709e3717.json").getInputStream();
        FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(certStream)).build();
        FirebaseApp.initializeApp(options);
        logger.info("完成 firebase ");
    }
}
