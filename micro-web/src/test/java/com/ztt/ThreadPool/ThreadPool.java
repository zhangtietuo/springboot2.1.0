package com.ztt.ThreadPool;

import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/22 16:37
 */
public class ThreadPool {


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, new ArrayBlockingQueue(1), new DefaultThreadFactory("ztt-pool-%d", true), new ThreadPoolExecutor.CallerRunsPolicy());
        executor.execute(new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "A-");
                Thread.sleep(5000);
                System.out.println("A");
            }
        });
        executor.execute(new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "B-");
                Thread.sleep(5000);
                System.out.println("B");
            }
        });
        executor.execute(new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "C-");
                Thread.sleep(5000);
                System.out.println("C");
            }
        });
        executor.execute(new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "D-");
                Thread.sleep(5000);
                System.out.println("D");
            }
        });
        System.out.println("xixi");




//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<Runnable>(5));
//        executor.execute(new Thread() {
//            @Override
//            public void run() {
//                System.out.println("开始进行");
//            }
//        });
//        /*for(int i=0;i<15;i++){
//            MyTask myTask = new MyTask(i);
//            executor.execute(myTask);
//            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
//                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
//        }
//        executor.shutdown();*/
//        Executors.newCachedThreadPool();
    }

    static class MyTask implements Runnable {
        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行task " + taskNum);
            try {
                Thread.currentThread().sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + "执行完毕");
        }
    }
}
