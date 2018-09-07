package com.ztt.practice;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/9/7 9:29
 */
public class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }
    {
        System.out.println("im a class");
    }
    static {
        System.out.println("im static a ");
    }

    public int get() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public void setValueA(String str) {
        str = "abc";
    }

    public static void main(String[] args) {
        HelloA a = new HelloA();
        System.out.println(a.get());
        String b = "123";
        a.setValueA(b);
        System.out.println(b);
    }
}
