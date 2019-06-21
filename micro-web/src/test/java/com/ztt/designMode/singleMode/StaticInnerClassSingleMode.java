package com.ztt.designMode.singleMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/21 14:45
 */
public class StaticInnerClassSingleMode {

    /**
     * 之所以是线程安全的，是因为Singleton是静态的，静态内部类只会被实例化一次，也就是说不管有多少线程，大家拿到的是同一个实例，不会再去进行多次实例化，从而达到了线程安全的目的。
     */
    private static class Singleton{
        private static StaticInnerClassSingleMode single = new StaticInnerClassSingleMode();
    }

    public static StaticInnerClassSingleMode getInstance(){
        return Singleton.single;
    }
}
