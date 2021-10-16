package com.ztt.Arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/8/15 18:18
 */
public class Sort {


    /**
     * 插入排序
     *
     * @param arr
     */
    public static void InsertSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else
                    break;
            }
        }
    }

    /**
     * 插入排序2(更快)
     *
     * @param arr
     */
    public static void InsertSort2(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int baseNumber = arr[j];//先把牌抽出来
            for (; j - 1 >= 0; j--) {
                if (arr[j - 1] > baseNumber) {
                    arr[j] = arr[j - 1];//后面的往前推
                } else
                    break;
            }
            arr[j] = baseNumber;//结束后把牌插入到空位
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{11, 9, 10, 7, 6};
        Integer[] arr1 = new Integer[]{13, 12, 10, 7, 6};
        Random random = new Random();
        InsertSort(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
        InsertSort(arr1);
        for (Integer integer : arr1) {
            System.out.println(integer);
        }
    }
}
