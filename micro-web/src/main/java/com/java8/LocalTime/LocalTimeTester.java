package com.java8.LocalTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/5/22 10:22
 */
public class LocalTimeTester {

    public static void main(String args[]) {
        LocalTimeTester java8tester = new LocalTimeTester();
        java8tester.testLocalDateTime();
    }

    public void testLocalDateTime() {

        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);
        System.out.println("当前时间: " + new Date());

        LocalDate date1 = currentTime.toLocalDate();
        LocalTime time1 = currentTime.toLocalTime();
        System.out.println("date1: " + date1);
        System.out.println("time1: " + time1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }
}
