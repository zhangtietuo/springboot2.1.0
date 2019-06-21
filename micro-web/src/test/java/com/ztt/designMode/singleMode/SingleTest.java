package com.ztt.designMode.singleMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/21 14:22
 */
public class SingleTest {

    public static void main(String[] args) {
        LazySingleMode lazySingleMode = LazySingleMode.getInstance();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(DubbleLockSingleMode.getInstance().hashCode());
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(DubbleLockSingleMode.getInstance().hashCode());
            }
        },"t2");

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(DubbleLockSingleMode.getInstance().hashCode());
            }
        },"t3");

        t1.start();
        t2.start();
        t3.start();
    }

}
