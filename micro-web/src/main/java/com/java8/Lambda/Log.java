package com.java8.Lambda;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/5/28 14:59
 */
public interface Log {

    public static boolean a = false;
    public final boolean b = false;
    public static final boolean c = false;

    void info(String desc);

    default void error(String name) {
        if (a) {
            System.out.println("ztt=" + name);
        }
    }
}
