package com.ztt.designMode.factoryMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/15 14:39
 */
public class Demo {

    public static void main(String[] args) {
        HairFactory hairFactory = new HairFactory();
        hairFactory.getHair("left");
    }
}
