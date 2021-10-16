package com.ztt.practice;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/9/7 10:00
 */
public class Demo {
    public static void main(String[] args) {
        A a1 = new A();
        a1.m();
        System.out.println(a1.z);
        A a2 = new B();
        a2.m();
        System.out.println(a2.z);
        B b1 = (B) a2;
        b1.m();
        System.out.println(b1.z);
        B b2 = new B();
        b2.m();
        System.out.println(b2.z);
    }
}
