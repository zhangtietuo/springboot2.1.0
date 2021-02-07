package com.ztt.entity;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/29 9:56
 */
@Order()
@Component
public class User {

    public User() {
        System.out.println("User");
    }

    {
        System.out.println("{}");
    }

    static {
        System.out.println("static");
    }
}
