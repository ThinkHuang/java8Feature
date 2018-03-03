package com.huang.feature.datetime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * 时间和日期的组合对象，该对象具有不可变性
 * @author huangyejun
 *
 */
public class LocalDateTimes
{
    public static void main(String[] args)
    {
        LocalDateTime sytvester = LocalDateTime.of(2014, Month.JANUARY, 4, 23, 59, 59);
        DayOfWeek dayOfWeek = sytvester.getDayOfWeek();
        System.out.println(dayOfWeek);
        
        Month month = sytvester.getMonth();
        System.out.println(month);
        
        long minuteOfDay = sytvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);//表示这一天有多少分钟，针对当前时间日期对象来说
        
        Instant instant = sytvester.atZone(ZoneId.systemDefault()).toInstant();
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);
        
        // 时间日期格式化，时间日期格式化对象不可变
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String str = formatter.format(parsed);
        System.out.println(str);
    }
}
