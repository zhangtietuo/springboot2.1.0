package com.ztt.designMode.E_BuilderMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/6 14:03
 */
public class Concrete2Builder extends Builder {

    @Override
    public void buildPartA() {
        product.setPartA("建造2 PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("建造2 PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("建造2 PartC");
    }

    @Override
    public Product getResult() {
        product.setPartA("建造2子类重写 PartA");
        return product;
    }
}
