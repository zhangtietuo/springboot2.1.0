package com.ztt.java_core.Exception;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/18 16:21
 */
public class ExceptionAndErrorAndTryCatch {

    public static void main(String[] args) {
        System.out.println(new ExceptionAndErrorAndTryCatch().test());
    }

    static int test() {
        int x = 1;
        try {
            x++;
            return x;
        } finally {
            ++x;
            System.out.println(x);
        }
    }

    static int test1() {
        int x = 1;
        try {
            return x++;
        } finally {
            return ++x;
        }
    }
}
