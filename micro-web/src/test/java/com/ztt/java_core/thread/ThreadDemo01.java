package com.ztt.java_core.thread;

import java.util.concurrent.Callable;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/7/18 17:10
 */
public class ThreadDemo01 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadDemo("A"));
        //Thread t2 = new Thread(new RunnableDemo("B"));
        System.out.println(t1.isAlive());
        t1.start();
        System.out.println(t1.isAlive());
        //t2.start();
        for (int i = 0; i < 50; i++) {
            if (i > 10) {
                t1.join();
                /**join方法可以传递参数，join(10)表示main线程会等待t1线程10毫秒，10毫秒过去后，
                 * main线程和t1线程之间执行顺序由串行执行变为普通的并行执行
                 * join方法的原理就是调用相应线程的wait方法进行等待操作的，例如A线程中调用了B线程的join方法，则相当于在A线程中调用了B线程的wait方法，当B线程执行完（或者到达等待时间），B线程会自动调用自身的notifyAll方法唤醒A线程，从而达到同步的目的。
                 */
                //t1.join(1);
            }
            System.out.println("主线程：" + i);
        }
    }


}

class RunnableDemo implements Runnable {

    private String name;

    public RunnableDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(name + ":" + i);
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class ThreadDemo extends Thread {

    private String name;

    public ThreadDemo(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(name + ":" + i);
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("实现callable的形式创建的线程");
        return 1024;
    }
}
