package com.ztt.designMode.E_BuilderMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/6 14:05
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder=builder;
    }

    //产品构建与组装方法
    public Product construct()
    {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
