package com.ztt.Arithmetic;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/7/3 16:59
 */
public class 移动零 {

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int j = 0;
        for(int i : nums){
            if(i != 0){
                nums[j] = i;
                j++;
            }
        }
        while(j < len){
            nums[j++] = 0;
        }

    }

    public static void main(String[] args) {
        int[] request = {0,1,0,3,12};
        moveZeroes(request);
    }
}
