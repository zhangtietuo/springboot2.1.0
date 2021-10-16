package com.ztt.designMode.E_BuilderMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/6 14:03
 */
public class Concrete1Builder extends Builder {


    @Override
    public void buildPartA() {
        product.setPartA("建造1 PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("建造1 PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("建造1 PartC");
    }
}
