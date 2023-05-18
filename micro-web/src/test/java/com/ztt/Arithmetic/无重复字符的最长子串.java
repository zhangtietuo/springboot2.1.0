package com.ztt.Arithmetic;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author tietuo.zhang
 * @Date 2023/2/27 16:30
 */
public class 无重复字符的最长子串 {

    public static int lengthOfLongestSubstring(String s) {
        char[] cArr = s.toCharArray();
        int j=0;
        int length = 0;
        Set<Character> set = new HashSet();
        for(int i =0;i<cArr.length;i++) {
            if(i !=0 ) {
                set.remove(cArr[i-1]);
            }
            while(j<cArr.length && !set.contains(cArr[j])) {
                set.add(cArr[j]);
                j++;
            }
            length = Math.max(length, j-i);

        }
        return length;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("bb");
    }
}
