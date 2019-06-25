package com.ztt.Arithmetic;

import java.util.Arrays;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/24 9:04
 */
public class 存在重复 {

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3};
        System.out.println(containsDuplicate(nums));
    }
}
