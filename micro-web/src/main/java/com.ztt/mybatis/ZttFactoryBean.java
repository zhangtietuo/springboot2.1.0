package com.ztt.mybatis;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/3/14 16:04
 */
public class ZttFactoryBean implements FactoryBean {

    Class clazz;

    public ZttFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Nullable
    @Override
    public Object getObject() throws Exception {
        Class[] clazzs = new Class[]{clazz};
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), clazzs, new ZttInvocationHandle());
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    class ZttInvocationHandle implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("============================");
            return null;
        }
    }
}
