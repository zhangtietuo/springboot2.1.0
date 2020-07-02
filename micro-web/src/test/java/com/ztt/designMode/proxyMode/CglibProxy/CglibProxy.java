package com.ztt.designMode.proxyMode.CglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/17 14:07
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * @param o           目标类实例
     * @param method      目标方法的反射对象
     * @param objects     方法的参数
     * @param methodProxy 代理类的实例
     * @date:2019/1/17 14:26
     * @author:zhangtietuo
     * @description:
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib开始");
        methodProxy.invokeSuper(o, objects);
        System.out.println("cglib结束");
        return null;
    }
}
