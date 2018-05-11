package com.java8.MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/5/10 16:35
 */
public class Java8Tester {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Java8Tester create(Supplier<Java8Tester> supplier) {
        return supplier.get();
    }

    public static void collide(Java8Tester Java8Tester) {
        System.out.println("Collided " + Java8Tester.toString());
    }

    public void follow(Java8Tester another) {
        System.out.println("Following " + this.toString());
        System.out.println("Following" + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        final Java8Tester java8Tester = create( Java8Tester::new );
        final List< Java8Tester > Java8Testers = Arrays.asList( java8Tester );
        Java8Testers.forEach( Java8Tester::collide );
        Java8Testers.forEach( Java8Tester::repair );
        final Java8Tester police = Java8Tester.create( Java8Tester::new );
        Java8Testers.forEach( police::follow );

        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
