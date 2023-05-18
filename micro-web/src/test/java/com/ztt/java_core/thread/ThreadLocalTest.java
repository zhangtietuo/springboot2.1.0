package com.ztt.java_core.thread;

import lombok.SneakyThrows;
import org.slf4j.MDC;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/4/1 9:24
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> request = new ThreadLocal<Integer>();

    static int num = 0;

    static int get() {
        return num;
    }

    static int add() {
        num++;
        return 1;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始");
//        for (int i = 0; i < 100; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    add();
//                }
//            }.start();
//        }
//        Thread.sleep(1000);
//        System.out.println(num);
//        new Thread() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    request.set(1);
//                    System.out.println(request.get());
//                    Thread.sleep(600000);
//                    System.out.println(request.get());
//                }
//            }.start();
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                request.set(2);
                System.out.println(request.get());
                request.set(4000);
                System.out.println(request.get());
                ThreadLocal threadLocal = new ThreadLocal();
                threadLocal.set(5000);
            }
        }.start();
        Thread.sleep(200000);

        request.set(3);
        Thread.sleep(10000);

        System.out.println(request.get());
    }
}
