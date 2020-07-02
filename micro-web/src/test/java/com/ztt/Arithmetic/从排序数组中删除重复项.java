package com.ztt.Arithmetic;

import org.apache.commons.collections.ListUtils;

import java.util.Arrays;

/**
 * @Auther: zhangtietuo
 * @Description: 双指针法
 * @Date: 2019/3/15 14:28
 */
public class 从排序数组中删除重复项 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 2)
            return nums.length;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] numarr = new int[]{1, 1, 2, 2, 3, 4, 4, 4, 5, 6, 7};
        System.out.println(removeDuplicates(numarr));
    }
}
