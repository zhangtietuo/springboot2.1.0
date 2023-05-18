package com.ztt.Thread;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/2/22 11:18
 */
public class Demo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
        thread1.start();
        thread2.start();

    }
}
