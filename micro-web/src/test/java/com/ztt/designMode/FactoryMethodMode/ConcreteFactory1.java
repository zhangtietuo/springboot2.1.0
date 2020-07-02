package com.ztt.designMode.FactoryMethodMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/2 14:25
 */
public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}
