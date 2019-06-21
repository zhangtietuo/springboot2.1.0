package com.ztt.designMode.singleMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/21 14:52
 */
public class DubbleLockSingleMode {

    private static DubbleLockSingleMode ds;

    public static DubbleLockSingleMode getInstance() {
        System.out.println(Thread.currentThread().getName() + ",coming");
        if (ds == null) {
            try {
                //模拟初始化对象的准备时间...
                System.out.println(Thread.currentThread().getName() + ",prepare sleep 3s");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + ",sleep over");
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (DubbleLockSingleMode.class) {
                System.out.println(Thread.currentThread().getName() + ",own lock");
                if (ds == null) {
                    ds = new DubbleLockSingleMode();
                }
                System.out.println(Thread.currentThread().getName() + ",release lock");
            }
        }
        return ds;
    }
}