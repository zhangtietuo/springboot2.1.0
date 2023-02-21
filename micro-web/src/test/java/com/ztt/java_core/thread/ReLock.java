package com.ztt.java_core.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author tietuo.zhang
 * @Date 2023/2/20 20:51
 */
public class ReLock {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock(true);
        lock.lock();
        System.out.println(1111);
        new Thread() {
            @Override
            public void run() {
                lock.lock();
            }
        }.start();
        Thread.sleep(30000);
        new Thread() {
            @Override
            public void run() {
                lock.lock();
            }
        }.start();
        lock.unlock();
    }
}
