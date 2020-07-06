package com.ztt.designMode.F_proxyMode.Jdkproxy;

import com.ztt.designMode.F_proxyMode.Car;
import com.ztt.designMode.F_proxyMode.Moveable;

import java.lang.reflect.Proxy;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/17 13:09
 */
public class Demo {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        CarProxy carProxy = new CarProxy();
        Moveable moveable = (Moveable) carProxy.getProxy(Car.class);
        moveable.move();
    }


}
