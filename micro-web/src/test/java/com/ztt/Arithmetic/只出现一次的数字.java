package com.ztt.Arithmetic;


import java.util.Arrays;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/25 9:31
 */
public class 只出现一次的数字 {

    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            System.out.println(nums[i]);
            System.out.println(result);
            result = result ^ nums[i];
            System.out.println("result:" + result);
            System.out.println("=============");
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,1,2, 3,3,2};
        System.out.println(singleNumber(nums));
    }
}
