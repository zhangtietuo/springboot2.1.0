package com.ztt.practice;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/9/7 9:57
 */
public class B extends A {
    public int z1 = 11;

    public void m1() {
        System.out.println("B");
    }

    public static void main(String[] args) {
        B b = new B();
        int x = b.z;
        b.m();
    }
}
