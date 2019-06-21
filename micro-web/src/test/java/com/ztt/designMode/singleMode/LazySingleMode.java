package com.ztt.designMode.singleMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/21 14:21
 */
public class LazySingleMode {

    private static LazySingleMode lazySingleMode = null;

    private LazySingleMode () {

    }

    public static LazySingleMode getInstance() {
        if(null == lazySingleMode) {
            lazySingleMode = new LazySingleMode();
        }
        return lazySingleMode;
    }

}
