package com.hx.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    // 截取非数字
    public static String splitNotNumber(String content) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    // 获取32位UUID
    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // 判断字符串是否为空
    public static boolean isEmpty(final String string){
        return string==null || string.isEmpty();
    }

    // 判断字符串是否为空(包含空格情况)
    public static boolean isEmptyOrTrim(final String string){
        return StringUtil.isEmpty(string) || string.trim().isEmpty();
    }

    //将格式如2020-01-20 11:09:37的字符串 变成2020012011格式
    public static String formatString(String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);//字符串转日期yyyy-MM-dd HH:mm:ss
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String str1 = simpleDateFormat1.format(date);//日期转字符串
        System.out.println(str1);
        String substring = str1.substring(2, 10);
        return substring;
    }



}
