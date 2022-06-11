package com.ztt.Arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tietuo.zhang
 * @title:
 * @Description:
 * @date 2022/6/10 22:27
 */
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if(length < 3) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<=length-3; i++) {
            int j = i+1;

            for(;j<=length-2;j++) {
                int k = j+1;
                for(;k<=length-1;k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[k]);
                        list.add(a);
                    }
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        三数之和 test = new 三数之和();
        System.out.println(test.threeSum(new int[]{-1,0,1,2,-1,-4}));;
        //-4 -1 -1 0 1 2
    }
}
