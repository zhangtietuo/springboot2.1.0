package com.ztt.designMode.A_singleMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/21 14:22
 */
public class SingleTest {

    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton.getName());
        hungrySingleton.setName("1");
        hungrySingleton.setName("2");
        System.out.println(hungrySingleton.getName());
        LazySingleton lazySingleton = LazySingleton.getInstance();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(DubbleLockSingleMode.getInstance().hashCode());
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(DubbleLockSingleMode.getInstance().hashCode());
            }
        }, "t2");

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(DubbleLockSingleMode.getInstance().hashCode());
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }

}
