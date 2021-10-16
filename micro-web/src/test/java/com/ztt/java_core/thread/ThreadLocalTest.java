package com.ztt.java_core.thread;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/4/1 9:24
 */
public class ThreadLocalTest {

    static int num = 0;

    static int get() {
        return num;
    }

    static int add() {
        num++;
        return 1;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    add();
                }
            }.start();
        }
        Thread.sleep(1000);
        System.out.println(num);
    }
}
