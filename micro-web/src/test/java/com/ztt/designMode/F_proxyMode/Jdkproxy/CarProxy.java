package com.ztt.designMode.F_proxyMode.Jdkproxy;

import com.ztt.designMode.F_proxyMode.Car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/17 12:51
 */
public class CarProxy implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在InvocationHandler添加日志开始.......");
        method.invoke(target);
        System.out.println("在InvocationHandler添加日志结束.......");
        return null;
    }

    public Object getProxy(Object target) throws IllegalAccessException, InstantiationException {
        Class c = (Class) target;
        this.target = c.newInstance();
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }
}
