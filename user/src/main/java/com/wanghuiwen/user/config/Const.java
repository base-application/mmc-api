package com.wanghuiwen.user.config;

import java.util.regex.Pattern;

public class Const {
    //未处理
    public static  final  int USER_FRIEND_APPLY_WAITING = 1;
    //同意
    public static  final  int USER_FRIEND_APPLY_AGREE = 2;
    //拒绝
    public static  final  int USER_FRIEND_APPLY_REFUSE = 3;

    public static final int VERIFICATION_REGISTER = 1;
    public static final int VERIFICATION_FORGOT = 2;


    //未处理
    public static  final  int EVENT_WAITING = 1;
    //同意
    public static  final  int EVENT__AGREE = 2;
    //拒绝
    public static  final  int EVENT__REFUSE = 3;


    //已读
    public static  final  int NOTIFICATION_READ = 1;
    //删除
    public static  final  int NOTIFICATION__DELETE= 2;

    public static final Pattern  REGEX_HTML = Pattern.compile("<[^>]+>", Pattern.CASE_INSENSITIVE);

}
