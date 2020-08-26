package com.ray.parent.common.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zrc on 2020-08-26.
 */
public class TimeUtils {
    /**
     * 现在到今天结束的毫秒数
     */
    public static Long getCurrent2TodayEndMillisTime() {
        final Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        return todayEnd.getTimeInMillis() - new Date().getTime();
    }
    /**
     * 现在到今天结束的秒数
     */
    public static int getCurrent2TodayEndSECONDTime() {
        Long millis = getCurrent2TodayEndMillisTime()/1000;
        return millis.intValue();
    }
    /**
     * 时间转换成string
     *
     * @param date
     * @param format
     * @return
     */
    public static String parseUtilToString(Date date, String format) {
        if (date != null) {
            LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return localDateTime.format(formatter);
        } else {
            return null;
        }
    }
    /**
     * 日期型变量由 String 转换成 java.util.Date
     *
     * @param strDate String 型变量
     * @param format  日期格式
     * @return java.util.Date 型变量
     */
    public static Date parseStringToUtil(String strDate, String format) {
        if (strDate == null) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(strDate);
        } catch (Exception ex) {
            return null;
        }
    }
    /**
     * 日期型变量由 String 转换成 java.sql.Timestamp
     *
     * @param strDate
     * @param format
     * @return
     */
    public static Timestamp parseStringToTimestamp(String strDate, String format) {
        if (strDate == null) {
            return null;
        }
        return new Timestamp(parseStringToUtil(strDate, format).getTime());
    }

    /**
     * 是否在同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        return DateUtils.isSameDay(date1, date2);
    }
    /**
     * 增加分钟
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addMinute(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, amount);
        return c.getTime();
    }
    public static int nowDay(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }
    public static int nowMonth(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH)+1;
    }
    public static int nowYear(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
}
