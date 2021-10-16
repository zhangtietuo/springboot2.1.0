package com.ztt.practice;

import java.util.ArrayList;
import java.util.List;

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

        new Thread( new Runnable() {                //1，将Runnable的子类对象当作参数传递给Thread的构造方法  ；new Runnable(){}：实现Runnable接口
            public void run(){                      //2，重写run方法
                for (int i = 0; i < 1000; i++) {        //3，将要执行的代码写到run方法中
                    System.out.println("wsq");
                }
            }
        }).start();
        try {
            System.out.println(1);
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.println(3);
            return 3;
        }
    }

    public void setValueA(String str) {
        str = "abc";
    }

    public static void setValueAA(String str) {
        str = "abc";
    }

    public static void main(String[] args) {
        HelloA a = new HelloA();
        System.out.println(a.get());
        String b = "123";
        a.setValueA(b);
        System.out.println(b);
        setValueAA(b);
        System.out.println(b);

        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        System.out.println(classStringArrayList.getName());

    }
}
