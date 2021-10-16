package com.ztt.java_core;

import java.math.BigInteger;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/18 18:52
 */
public class BitOperation {

    private static char[] a;
    private static char b[];

    public static void main(String[] args) {
        new String("111".toCharArray(), 3, 0);
        System.out.println("-2^3运算的结果是11111110 ^ 00000011 11111101 10000010 10000011 -3 :" + (-2 ^ 3));
        System.out.println("2&3运算的结果是 :" + (2 & 3));
        System.out.println("3<<2运算的结果是 :" + (3 << 2));
        System.out.println("15>>2运算的结果是 :" + (15 >> 2));
        System.out.println("16>>>2运算的结果是 :" + (16 >>> 2));
        System.out.println("-16>>2运算的结果是 :" + (-16 >> 2));

        int a = 0b111;
        System.out.println(a);

        int num = 100;
        //36进制
        System.out.println(Integer.toString(num, 36));

        System.out.println(new BigInteger("100"));
    }
}
