package com.ztt.java_core.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: zhangtietuo
 * @Description: 可以将 ArrayList想象成一种“会自动扩增容量的Array”。
 * @Date: 2018/9/3 10:50
 */
public class Array {

    public static String[] array = new String[]{"1", "2", "3"};

    public static void main(String[] args) {
        ArrayListOperation();
    }

    public static void ArrayListOperation() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.isEmpty());
        //list.clear();
        System.out.println(list.get(0));
        System.out.println(list.indexOf(5));
        System.out.println(list.size());
        list.add(1, 5);
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list.get(1));

        LinkedList<String> linkedList = new LinkedList();
        //linkedList
    }

    public static void ArrayAdd(String[] numArr) {

    }
}
