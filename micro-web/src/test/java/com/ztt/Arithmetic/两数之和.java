package com.ztt.Arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangtietuo
 * @Description: 夏天在等雪下，冬天在等花开，而我在等你
 * @Date: 2019/7/4 10:04
 */
public class 两数之和 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] request = {3,2,4};
        twoSum(request, 6);
    }
}
