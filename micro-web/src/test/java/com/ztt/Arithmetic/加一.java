package com.ztt.Arithmetic;

import java.util.Arrays;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/28 17:10
 */
public class 加一 {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 != 10) {
                digits[i] += 1;
                break;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    for (int j = 0; j < digits.length - 1; j++) {
                        result[j + 1] = digits[j];
                    }
                    return result;
                }
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {1, 9, 9};
        int[] result = plusOne(digits);
        for (int a : result) {
            System.out.println(a);
        }
    }
}
