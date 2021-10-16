package com.ztt.designMode.F_proxyMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/16 16:49
 */
public class CarLogProxy implements Moveable {


    private Moveable m;

    public CarLogProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("日志开始......");
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.println("日志结束......");
    }
}
