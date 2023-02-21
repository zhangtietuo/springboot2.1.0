package com.java8;

/**
 * @Description
 * @Author tietuo.zhang
 * @Date 2022/8/19 18:24
 */
public class Test {


    public static void main(String[] args) {
        System.out.println(Test.longestPalindrome("aacabdkacaa"));
    }

    public static String longestPalindrome(String s) {

        char[] arr = s.toCharArray();
        String r = null;
        boolean[][] result = new boolean[arr.length][arr.length];
        int start1=0,length=1;
        for(int i=0;i<arr.length;i++) {
            result[i][i] = true;
        }
        for(int L=2;L<=arr.length;L++) {
            int start=0;
            while(start+L-1<arr.length) {
                if(arr[start] != arr[start+L-1]) {
                    result[start][start+L-1] = false;
                    start++;
                } else {
                    if(L>2) {
                        result[start][start+L-1] = result[start+1][start+L-2];
                    } else {
                        result[start][start+L-1] = true;
                    }
                    start1 = start;
                    length = L;
                    start++;

                }
            }
        }


        return s.substring(start1, start1+length);
    }
}
