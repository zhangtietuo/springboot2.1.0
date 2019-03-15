package com.ztt.Arithmetic;

import org.apache.commons.collections.ListUtils;

import java.util.Arrays;

/**
 * @Auther: zhangtietuo
 * @Description: 双指针法
 * @Date: 2019/3/15 14:28
 */
public class 从排序数组中删除重复项 {

    public static int removeDuplicates(int[] numarr) {
        if (numarr.length == 0) {
            return 0;
        }

        int number = 0;
        for (int i = 1; i < numarr.length; i++) {
            if (numarr[i] != numarr[number]) {
                number++;
                numarr[number] = numarr[i];
            }
        }
        System.out.println(Arrays.toString(numarr));
        return number + 1;
    }

    public static void main(String[] args) {
        int[] numarr = new int[] {1, 1, 2, 2, 3, 4, 4, 4, 5, 6, 7};
        System.out.println(removeDuplicates(numarr));
    }
}
