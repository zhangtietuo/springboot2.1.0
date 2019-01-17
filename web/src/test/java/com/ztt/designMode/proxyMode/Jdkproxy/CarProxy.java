package com.ztt.designMode.proxyMode.Jdkproxy;

import com.ztt.designMode.proxyMode.Car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/17 12:51
 */
public class CarProxy implements InvocationHandler {

    private Object target;

    public CarProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在InvocationHandler添加日志开始.......");
        method.invoke(target);
        System.out.println("在InvocationHandler添加日志结束.......");
        return null;
    }
}
