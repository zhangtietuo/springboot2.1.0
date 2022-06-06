package com.ztt.java_core.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author tietuo.zhang
 * @title:
 * @Description:
 * @date 2022/6/4 12:05
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
