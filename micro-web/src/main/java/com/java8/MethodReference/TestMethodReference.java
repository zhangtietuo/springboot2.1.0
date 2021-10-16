package com.java8.MethodReference;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/9/4 14:12
 */

public class TestMethodReference {

    public static void main(String[] args) {
        Person[] pArr = new Person[]{
                new Person("003", LocalDate.of(2016, 9, 1)),
                new Person("001", LocalDate.of(2016, 2, 1)),
                new Person("002", LocalDate.of(2016, 3, 1)),
                new Person("004", LocalDate.of(2016, 12, 1))};

        // 使用匿名类
        /*Arrays.sort(pArr, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        });*/

        //使用lambda表达式
        /*Arrays.sort(pArr, (Person a, Person b) -> {
            return a.getBirthday().compareTo(b.getBirthday());
        });*/

        //使用lambda表达式和类的静态方法
        //Arrays.sort(pArr, (a ,b) -> Person.compareByAge(a, b));

        //使用方法引用，引用的是类的静态方法
        Arrays.sort(pArr, Person::compareByAge);

        System.out.println(Arrays.asList(pArr));

        //引用对象的实例方法
        Person person = new Person("005", LocalDate.of(1993, 1, 30));
//        Supplier<LocalDate> supp = person::getBirthday;
//        System.out.println(supp.get());

        //引用类的实例方法
        //  BiPredicate<String, String> biPre=(str1,str2)->str1.equals(str2); [原来写法]
//        BiPredicate<String, String> biPre=String::equals;               //[使用方法引用]
//        System.out.println(biPre.test("aaa", "aaa"));

        //引用构造方法
        //Supplier<TestMethodReference> supp1=()->new TestMethodReference();
//        Supplier<TestMethodReference> supp1=TestMethodReference::new;
//        TestMethodReference stu=supp1.get();
//        System.out.println(supp1);

        //实例化一个长度为10的数组
        Function<Integer, String[]> supp2 = String[]::new;
        String[] array = supp2.apply(10);
        System.out.println(array.length);

    }
}
