package com.huang.feature.datetime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * LocalTime表示一个没有指定时区的时间
 * @author huangyejun
 *
 */
public class LocalTimes
{
    public static void main(String[] args)
    {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        
        System.out.println(now1.isBefore(now2));
        
        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        
        System.out.println(hoursBetween);
        System.out.println(minutesBetween);
        
        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.GERMAN);
        LocalTime leetTime = LocalTime.parse("13.37", formatter);
        System.out.println(leetTime);
        
    }
}
