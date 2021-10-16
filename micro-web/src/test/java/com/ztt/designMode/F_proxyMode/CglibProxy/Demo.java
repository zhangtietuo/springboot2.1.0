package com.ztt.designMode.F_proxyMode.CglibProxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/17 14:20
 */
public class Demo {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "com.ztt.designMode.F_proxyMode.CglibProxy");
        Train train = (Train) cglibProxy.getProxy(Train.class);
        train.run();
    }


}
