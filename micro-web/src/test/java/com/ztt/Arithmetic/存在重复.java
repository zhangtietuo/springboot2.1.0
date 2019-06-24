package com.ztt.Arithmetic;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/24 9:04
 */
public class 存在重复 {

    public static boolean containsDuplicate(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return false;
        }
        for(int i = 0; i<nums.length-1;i++) {
            for(int j = i+1; j<nums.length;j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
    }
}
