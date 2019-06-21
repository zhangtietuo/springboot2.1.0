package com.ztt.designMode.singleMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/21 14:21
 */
public class HungrySingleMode {

    private static HungrySingleMode lazySingleMode = new HungrySingleMode();

    private HungrySingleMode() {

    }

    public static HungrySingleMode getInstance() {
        return lazySingleMode;
    }

}
