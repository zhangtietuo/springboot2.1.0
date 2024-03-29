package com.java8;

import lombok.SneakyThrows;
import org.redisson.RedissonLock;

import java.util.ArrayList;

/**
 * @Description
 * @Author tietuo.zhang
 * @Date 2022/8/19 18:24
 */
public class Test {

    private final int a=0;

    static int x =10;

    static {
        System.out.println("asd"+x);
        x+=5;
    }

    static {
        System.out.println(x);
        x/=3;
    }


    public static void main(String[] args) {
        String z = "com.jd.".replaceAll(".", "q")+"Myclass.class";
        System.out.println(z);
        Thread t= new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(1000);
                pong();
            }
        };
        t.start();
        t.run();
        System.out.println("ping");
        System.out.println("x="+x);
        System.out.println(Test.longestPalindrome("aacabdkacaa"));
    }

    static void pong() {
        System.out.println("pong");
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

    public void a() {
        Test test = new Test();
        new ArrayList(20);
    }

    public static void b1()  {
        Runtime.getRuntime().gc();
        System.gc();
        System.out.println("Test");
    }

}
