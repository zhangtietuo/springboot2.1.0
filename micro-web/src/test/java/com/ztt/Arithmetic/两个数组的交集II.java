package com.ztt.Arithmetic;

import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/27 10:02
 */
public class 两个数组的交集II {

    public int[] intersect(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int lengtg2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        while (i < length1 && j < lengtg2) {
            if (nums1[i] == nums2[j]) {
                nums1[k] = nums2[j];
                k++;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[k];
        for (int l = 0; l < k; l++) {
            res[l] = nums1[l];
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
