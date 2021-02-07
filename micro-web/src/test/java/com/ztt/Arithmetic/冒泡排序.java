package com.ztt.Arithmetic;

import java.util.Arrays;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2021/2/3 23:06
 */
public class 冒泡排序 {

    public static void bubble(int[] num) {
        for(int i = num.length-1;i>0;i--) {
            for(int j=0;j<=i-1;j++) {
                if(num[j]>num[j+1]) {
                    int temp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        bubble(a);
        System.out.println(Arrays.toString(a));
    }
}
