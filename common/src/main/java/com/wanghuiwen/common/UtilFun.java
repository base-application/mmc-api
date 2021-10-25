package com.wanghuiwen.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by wanghuiwen on 17-2-23.
 */
public class UtilFun {
    static Logger logger = LoggerFactory.getLogger("util");

    public  static  final  String YYYYMMDDHHMMSS="yyyy-MM-dd HH:mm:ss";
    public  static  final  String YYYYMMDDHHMMSS3="yyyyMMddHHmmss";
    public  static  final  String YYYYMMDD2="yyyy/MM/dd";
    public  static  final  String YMD="yyyy-MM-dd";
    /**
     * 判断list不为
     *
     * @param list list
     * @return 为空返回true
     */
    public static boolean isEmptyList(List list) {
        return list == null || list.size() <= 0;
    }

    /**
     * 判断str不为
     *
     * @param str str
     * @return 为空返回true
     */
    public static boolean isEmptyString(String str) {
        return str == null || str.equals("");
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (!checkIP(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (!checkIP(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    private static boolean checkIP(String ip) {
        return ip != null && ip.length() != 0 && !"unkown".equalsIgnoreCase(ip)
                && ip.split(".").length == 4;
    }

    public  static  String DateToString(Date date,String fromat){
        SimpleDateFormat sdf = new SimpleDateFormat(fromat);
        return sdf.format(date);
    }

    public  static Date StringToDate(String datestr,String formatstr){
        DateFormat format= new SimpleDateFormat(formatstr);
        try {
            Date date =format.parse(datestr);
            return date;
        } catch (ParseException e) {
           logger.error("日期转换错误" + datestr,e);
            return null;
        }

    }

    public static  Date addDay(String date,int day){
        return addDay(StringToDate(date,YYYYMMDDHHMMSS),day);
    }

    public static  Date addDay(String date,int day,String fromat){
        return addDay(StringToDate(date,fromat),day);
    }


    public static Date addDay(Date date,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,day);
        return calendar.getTime();
    }

    /**
     * 首字母大
     * @param str start
     * @return str
     */
     public static String upperFristCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * 返回时间戳
     */
    public static Integer getIntTime(Date date){

        return Math.toIntExact(date.getTime() / 1000);
    }

    //生成随机用户名，数字和字母组成,
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }


    //生成随机用户名，数字,
    public static String getNumRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; ) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
                i++;
            }
        }
        return val;
    }

}
