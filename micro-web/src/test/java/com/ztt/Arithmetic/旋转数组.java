package com.ztt.Arithmetic;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/21 10:03
 */
public class 旋转数组 {

    public static void rotate(int[] nums, int k) {
        if (nums.length == 0 || (k %= nums.length) == 0) {
            return;
        }
        int length = nums.length;
        int start = 0;
        int i = 0;
        int cur = nums[i];
        int cnt = 0;

        while (cnt++ < length) {
            i = (i + k) % length;
            int t = nums[i];
            nums[i] = cur;
            if (i == start) {
                ++start;
                ++i;
                cur = nums[i];
            } else {
                cur = t;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        rotate(nums, 2);
        System.out.println(nums);
    }
}
