package com.ztt.designMode.FactoryMethodMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/2 14:24
 */
public class ConcreteProduct1 implements Product {

    @Override
    public void show() {
        System.out.println("具体产品1显示...");
    }
}
