package com.hxk.meetingfilm.backend.utils.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaokang.huang
 * @date 2020/6/5 14:39
 * @description 基础工具类
 */

public class ToolUtils {

    private ToolUtils(){};

    /**
     * 字符串为空
     * @param str
     * @return
     */
    public static boolean strIsNull(String str){
        if (str == null || str.trim().length() == 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 字符串不为空
     * @param str
     * @return
     */
    public static boolean strIsNotNull(String str){
        if(strIsNull(str)){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 判断数字正则表达式
     */
    private static final Pattern pattern = Pattern.compile("[0-9]*");

    /**
     * 检查字符串是否为int类型
     * @param str
     * @return
     */
    public static boolean checkInt(String str) {
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 将字符串转为int类型
     * @param str
     * @return
     */
    public static Integer str2Int(String str) {
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return 0;
        } else {
            return Integer.parseInt(str);
        }
    }

    /**
     * 将字符串转为LocalDateTime
     * @param dateStr
     * @return
     */
    public static LocalDateTime str2LocalDateTime(String dateStr) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(dateStr,df);
        return ldt;
    }

}
