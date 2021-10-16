package com.java8.Lambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/5/28 14:42
 */
public class LogDemo {

    public static void main(String[] args) {
        Random random = new Random();
        // 随机产生数据
        Stream<Integer> stream = Stream.generate(() -> random.nextInt())
                // 产生500个 ( 无限流需要短路操作. )
                .limit(10)
                // 第1个无状态操作
                .peek(s -> print("peek: " + s))
                // 第2个无状态操作
                .filter(s -> {
                    print("filter: " + s);
                    return s > 100;
                })
                // 有状态操作
                .sorted((i1, i2) -> {
                    print("排序: " + i1 + ", " + i2);
                    return i1.compareTo(i2);
                })
                // 又一个无状态操作
                .peek(s -> {
                    print("peek2: " + s);
                }).parallel();

        // 终止操作
        stream.count();
    }

    /**
     * 打印日志并sleep 5 毫秒
     *
     * @param s
     */
    public static void print(String s) {
        // System.out.println(s);
        // 带线程名(测试并行情况)
        System.out.println(Thread.currentThread().getName() + " > " + s);
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
    }
}
