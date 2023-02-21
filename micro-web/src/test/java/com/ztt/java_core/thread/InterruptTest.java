package com.ztt.java_core.thread;

import lombok.SneakyThrows;

/**
 * @Description
 * @Author tietuo.zhang
 * @Date 2023/2/21 16:50
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        StopThread thread = new StopThread();
        thread.start();
        // 休眠1秒，确保线程进入运行
        Thread.sleep(1000);
        // 暂停线程
      thread.interrupt();
        // 确保线程已经销毁
        while (thread.isInterrupted()) {
        }
        // 输出结果
        System.out.println("gg");
        thread.print();
    }

    private static class StopThread extends Thread {

        private int x = 0; private int y = 0;

        @SneakyThrows
        @Override
        public void run() {
            // 这是一个同步原子操作
            synchronized (this) {
                ++x;
                try {
                    // 休眠3秒,模拟耗时操作
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.sleep(5000);
                ++y;
                System.out.println("over");
            }
        }

        public void print() {
            System.out.println("x=" + x + " y=" + y);
        }
    }
}
