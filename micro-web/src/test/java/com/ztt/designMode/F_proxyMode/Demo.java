package com.ztt.designMode.F_proxyMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/16 16:46
 */
public class Demo {

    public static void main(String[] args) {
        Car car = new Car();
        CarTimeProxy ctp = new CarTimeProxy(car);
        CarLogProxy clp = new CarLogProxy(ctp);
        clp.move();
    }
}
