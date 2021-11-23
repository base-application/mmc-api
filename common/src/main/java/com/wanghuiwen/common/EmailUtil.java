package com.wanghuiwen.common;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailUtil extends Authenticator {


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
    public static void gmailSender (String email,String content) {

        // Get a Properties object
        Properties props = new Properties();
        //选择ssl方式
        gmailssl(props);

        final String username = "info@adrianwee.com";//gmail邮箱
        final String password = "P@ssw0rd!@#$%";//密码
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        // -- Create a new message --
        Message msg = new MimeMessage(session);


        // -- Set the FROM and TO fields --
        try {
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            msg.setSubject("验证邮箱");
            msg.setContent(  content ,SEND_ENCODING_LAYOUT);
//            msg.setText(prettyRegisterLayout("2小时",MAIL_ORGANIZATION,"https://www.xxxx.com/user/register/8asc824jnd741n2c"));
            msg.setSentDate(new Date());
            Transport.send(msg);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        System.out.println("Message sent.");
    }

    public static void main(String[] args) {
        gmailSender("wanghuiwen312@sina.com","text");
    }

}
