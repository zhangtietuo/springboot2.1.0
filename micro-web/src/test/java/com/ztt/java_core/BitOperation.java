package com.ztt.java_core;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/18 18:52
 */
public class BitOperation {

    public static void main(String[] args) {
        System.out.println("2^3运算的结果是 :"+(2^3));
        System.out.println("2&3运算的结果是 :"+(2&3));
        System.out.println("3<<2运算的结果是 :"+(3<<2));
        System.out.println("15>>2运算的结果是 :"+(15>>2));
        System.out.println("16>>>2运算的结果是 :"+(16>>>2));
        System.out.println("-16>>2运算的结果是 :"+(-16>>2));

        int a = 0b111;
        System.out.println(a);
    }
}
