package com.wanghuiwen.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailUtil extends Authenticator {

    static  Logger logger = LoggerFactory.getLogger("email.util");

    private static final String SEND_ENCODING_LAYOUT ="text/html;charset=utf-8";//发送邮件的编码格式

    /*
     * gmail邮箱SSL方式
     */
    private static void gmailssl(Properties props) {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.put("mail.debug", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");

    }


    //gmail邮箱的TLS方式
    private static void gmailtls(Properties props) {
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    /*
     * 通过gmail邮箱发送邮件
     */
    public static void gmailSender (String email,String content) throws MessagingException {

        // Get a Properties object
        Properties props = new Properties();
        gmailssl(props);
        final String username = "info@adrianwee.com";//gmail邮箱
        final String password = "P@ssw0rd!@#$%";//密码
        Session session = Session.getDefaultInstance(props, new Authenticator() {protected PasswordAuthentication getPasswordAuthentication() { return new PasswordAuthentication(username, password); }});

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username));
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
        msg.setSubject("验证邮箱");
        msg.setContent(content ,SEND_ENCODING_LAYOUT);
        msg.setSentDate(new Date());
        Transport.send(msg);
        logger.info("email send success");
    }
}
