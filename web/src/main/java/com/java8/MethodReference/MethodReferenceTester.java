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
public class MethodReferenceTester {
    //Supplier是jdk1.8的接口，这里和lambda一起使用了
    public static MethodReferenceTester create(Supplier<MethodReferenceTester> supplier) {
        return supplier.get();
    }

    public static void collide(MethodReferenceTester MethodReferenceTester) {
        System.out.println("Collided " + MethodReferenceTester.toString());
    }

    public void follow(MethodReferenceTester another) {
        System.out.println("Following " + this.toString());
        System.out.println("Following" + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        final MethodReferenceTester methodReferenceTester = create( MethodReferenceTester::new );
        final List<MethodReferenceTester> methodReferenceTesters = Arrays.asList(methodReferenceTester);
        methodReferenceTesters.forEach( MethodReferenceTester::collide );
        methodReferenceTesters.forEach( MethodReferenceTester::repair );
        final MethodReferenceTester police = MethodReferenceTester.create( MethodReferenceTester::new );
        methodReferenceTesters.forEach( police::follow );

        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
