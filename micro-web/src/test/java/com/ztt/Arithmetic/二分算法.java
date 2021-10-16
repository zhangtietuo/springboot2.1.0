package com.ztt.Arithmetic;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2021/2/2 17:02
 */
public class 二分算法 {

    public static int binarySearch(int[] arr, int key) {
        int middle;
        int begin = 0;
        int end = arr.length-1;
        while(begin <= end) {
            middle = (end + begin)/2;
            if(arr[middle] == key) {
                return middle;
            } else if(arr[middle] < key) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        System.out.println(binarySearch1(new int[]{1,2,3,4,5,6}, 5));
    }







    public static int binarySearch1(int[] arr, int num) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {
            int middle = (end+start)/2;
            if(arr[middle] == num) {
                return middle;
            } else if(arr[middle] < num) {
                start = middle +1;
            } else {
                end = middle-1;
            }
        }
        return -1;
    }
}
