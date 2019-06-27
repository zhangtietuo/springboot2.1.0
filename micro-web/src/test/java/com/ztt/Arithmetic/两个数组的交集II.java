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
        int num1length1 = nums1.length;
        int num2length2 = nums2.length;
        List<Integer> list = new ArrayList();
        int k = 0;
        for(int i=0;i<num1length1;i++) {
            int temp;
            for(int j = k;j<num2length2;j++) {
                if(nums1[i] == nums2[j]) {
                    temp = nums2[k];
                    nums2[k++] = nums2[j];
                    nums2[j] = temp;
                    list.add(nums1[i]);
                    break;
                }

            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {

    }

}
