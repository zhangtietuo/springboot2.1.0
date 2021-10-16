package com.ztt.java_core.thread;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/7/18 17:36
 */
public class Yield {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RunnableDemo1("A"));
        Thread t2 = new Thread(new RunnableDemo1("B"));
        t1.start();
        t2.start();

    }

}

class RunnableDemo1 implements Runnable {

    private String name;

    public RunnableDemo1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(name + ":" + i);
            if (i == 10) {
                System.out.println(name + "礼让");
                Thread.yield();
            }
        }
    }
}
