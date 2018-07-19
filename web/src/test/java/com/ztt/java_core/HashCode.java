package com.ztt.java_core;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/6/22 13:55
 */
public class HashCode {

    public static void main(String[] args) {
        Object a = "zzz";
        Object b = "zzz";
        System.out.println(a.equals(b));
        System.out.println(a == b);
        String c = new String("zzz");
        String d = new String("zzz");
        System.out.println(c.equals(d));
        System.out.println(c == d);
        System.out.println(a == d);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
    }
}
