package com.ztt.java_core.thread;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/7/18 17:59
 */
public class Synchronized {

    public static void main(String[] args) throws InterruptedException {
        RunnableDemo2 r = new RunnableDemo2();
        Thread t1 = new Thread(r, "A");
        Thread t2 = new Thread(r, "B");
        Thread t3 = new Thread(r, "C");
        t1.start();
        t2.start();
        t3.start();

    }

}

class RunnableDemo2 implements Runnable {



    private int ticket = 5;



    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            //System.out.println(Thread.currentThread().getName()+ ":"+i);
            synchronized (this) {
                if(ticket>0) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ "车票:"+ ticket--);
                }
            }

        }
    }
}
