package com.wanghuiwen.common;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SetSMSAttributesRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class MessageUtil {
    static Logger logger = LoggerFactory.getLogger("msg");
    final static String regionId = "";
    final static String accessKeyId = "";
    final static String secret = "";
    public static void aliSmsSend(String phone,String code) {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, secret);//自己账号的AccessKey信息
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");//短信服务的服务接入地址
        request.setSysVersion("2017-05-25");//API的版本号
        request.setSysAction("SendSms");//API的名称
        request.putQueryParameter("PhoneNumbers", phone);//接收短信的手机号码
        request.putQueryParameter("SignName", "阿里大于测试专用");//短信签名名称
        request.putQueryParameter("TemplateCode", "SMS_209335004");//短信模板ID
        Map<String,String> params = new HashMap<>();
        params.put("code",code);
        request.putQueryParameter("TemplateParam", JSONUtils.obj2json(params));//短信模板变量对应的实际值
        try {
            CommonResponse response = client.getCommonResponse(request);
            logger.info(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


    public static void amazonSMSSender(String phoneNumber,String message){
        AmazonSNSClientBuilder clientBuilder = AmazonSNSClientBuilder.standard();
        AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAJBQ3TFD6K2U7JRJA", "XdvRP6bAN3ieDK7IS+Tsektw+Vf2BmnPlkfWRczs");
        AWSStaticCredentialsProvider provider = new AWSStaticCredentialsProvider(awsCredentials);
        clientBuilder.setCredentials(provider);
        // Regions 就是你选择从哪个国家的服务器接入,价格参考 https://amazonaws-china.com/cn/sns/sms-pricing/
        clientBuilder.setRegion(Regions.AP_SOUTHEAST_1.getName());

        AmazonSNSClient snsClient = (AmazonSNSClient) clientBuilder.build();
        SetSMSAttributesRequest setRequest = new SetSMSAttributesRequest().addAttributesEntry("MonthlySpendLimit", "20");
        snsClient.setSMSAttributes(setRequest);
        sendSMSMessage(snsClient, message, phoneNumber);
    }
    public static void sendSMSMessage(AmazonSNSClient snsClient, String message,
                                      String phoneNumber) {
        logger.info("+_+_+_+_+_+_+_+_+begin send sms +_+_+_+_+_+_+__+_+_+_+_+_+_+__+");
        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber));
        logger.info(JSONUtils.obj2json(result));
        logger.info("+_+_+_+_+_+_+_+_+end send sms +_+_+_+_+_+_+__+_+_+_+_+_+_+__+");
    }

    public static void main(String[] args) {
        amazonSMSSender("+60 162118847","a test message");
    }



}