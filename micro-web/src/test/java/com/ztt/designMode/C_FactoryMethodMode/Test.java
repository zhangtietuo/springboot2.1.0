package com.ztt.designMode.C_FactoryMethodMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/2 14:26
 */
public class Test {

    public static void main(String[] args) {
        Product a;
        AbstractFactory af;
        af= new ConcreteFactory1();
        a=af.newProduct();
        a.show();
    }
}
