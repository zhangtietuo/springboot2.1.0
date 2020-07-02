package com.ztt.designMode.proxyMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/16 16:44
 */
public class CarTimeProxy implements Moveable {

    private Moveable m;

    public CarTimeProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.println("🚵行驶时间为:" + (endTime - startTime) + "ms");
    }
}
