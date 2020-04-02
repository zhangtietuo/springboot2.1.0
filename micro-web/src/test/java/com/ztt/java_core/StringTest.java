package com.ztt.java_core;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/4/2 13:34
 */
public class StringTest {

    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);
        System.out.println(s.intern() == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
