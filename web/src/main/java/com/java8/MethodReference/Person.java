package com.java8.MethodReference;

import java.time.LocalDate;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/9/4 14:12
 */
public class Person {

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    String name;
    LocalDate birthday;

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        return this.name;
    }
}