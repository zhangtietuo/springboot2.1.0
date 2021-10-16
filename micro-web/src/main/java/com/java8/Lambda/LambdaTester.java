package com.java8.Lambda;

/**
 * @Auther: zhangtietuo
 * @Description: 用lambda表达式创建匿名方法
 * @Date: 2018/5/10 16:35
 */
public class LambdaTester {

    static String salutation = "Hello! ";


    public static void main(String args[]) {


        LambdaTester tester = new LambdaTester();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句必须有return
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 + 5 = " + addition.operation(10, 5));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));
        System.out.println("1 + 2 + 3 = " + addition.operation1(1, 2, 3));


        // 不用括号
        GreetingService greetService1 = message -> //参数只能调用一次
                System.out.println(salutation + message);
        //System.out.println(salutation + message);

        // 用括号
        GreetingService greetService2 = (message) -> System.out.println(salutation + message);


        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation { //函数式接口:接口中必须有且只有一个抽象方法,但是可以有多个非抽象方法的接口,可以被隐式转换为lambda表达式
        int operation(int a, int b); //抽象方法

        default int operation1(int a, int b, int c) { //非抽象方法
            return a + b + c;
        }

        static int operation2(int a, int b) { //非抽象方法
            return a + b;
        }
    }

    @FunctionalInterface
    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
