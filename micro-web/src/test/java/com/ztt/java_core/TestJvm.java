package com.ztt.java_core;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/29 14:18
 */
public class TestJvm {

    public static void main(String[] args) {
        test();
    }

    static void test() {
        int i = 1;
        int k = 2;
        int j = i * k;
        System.out.println(j);

    }
}
