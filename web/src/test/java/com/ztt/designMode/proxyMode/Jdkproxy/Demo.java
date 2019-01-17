package com.ztt.designMode.proxyMode.Jdkproxy;

import com.ztt.designMode.proxyMode.Car;
import com.ztt.designMode.proxyMode.Moveable;

import java.lang.reflect.Proxy;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/17 13:09
 */
public class Demo {

    public static void main(String[] args) {

        Car car = new Car();
        CarProxy carProxy = new CarProxy(car);

        Moveable moveable = (Moveable) Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), carProxy);
        moveable.move();
    }


}
