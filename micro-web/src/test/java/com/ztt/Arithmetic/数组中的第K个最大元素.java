package com.ztt.Arithmetic;

/**
 * @author tietuo.zhang
 * @title: 快速选择
 * @Description:
 * @date 2022/6/11 13:22
 */
public class 数组中的第K个最大元素 {

    public static void main(String[] args) {
        数组中的第K个最大元素 test = new 数组中的第K个最大元素();
        test.findK(new int[]{-1,0,1,2,-1,-4}, 3);
    }

    int findK(int[] arr, int k) {
        int length = arr.length;
        quickSort(arr, 0, length-1);
        return arr[arr.length-k];
    }

    private void quickSort(int[] arr, int min, int max) {
       if(min < max) {
           int split = partition(arr, min, max);
           quickSort(arr, min, split-1);
           quickSort(arr, split+1, max);
       }

    }

    private int partition(int[] arr, int min, int max) {
        int splitNum = arr[min];
        while(min < max) {
            while(min < max && splitNum <= arr[max]) {
                max--;
            }
            swap(arr, min, max);
            while(min < max && splitNum >= arr[min]) {
                min++;
            }
            swap(arr, min, max);
        }
        return min;
    }

    private void swap(int[] arr, int min, int max) {
        int tem = 0;
        tem = arr[min];
        arr[min] = arr[max];
        arr[max] = tem;
    }
}
