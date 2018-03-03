package com.huang.feature.datetime;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * Clock对时区敏感，提供了对日期和时间的访问功能
 * 通过Instant对象，可以创建原先的Date对象
 * @author huangyejun
 *
 */
public class Clocks
{
    public static void main(String[] args)
    {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();//获取毫秒值
        
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);// legacy java.util.Date
    }
}
