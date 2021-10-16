package com.ztt.designMode.C_FactoryMethodMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/2 14:25
 */
public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}
