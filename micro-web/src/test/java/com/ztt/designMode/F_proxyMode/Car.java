package com.ztt.designMode.F_proxyMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/16 16:42
 */
public class Car implements Moveable {


    @Override
    public void move() {
        try {
            System.out.println("正在行驶中....");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
