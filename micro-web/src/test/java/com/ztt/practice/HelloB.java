package com.ztt.practice;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/9/7 9:38
 */
public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }

    {
        System.out.println("im b class");
    }

    static {
        System.out.println("im static b ");
    }

    public static void setValue(String str) {
        str = "abc";
    }

    public static void main(String[] args) {
        new HelloB();
        String str = "123";
        setValue(str);
        System.out.println(str);
    }
}
