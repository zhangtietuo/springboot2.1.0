package com.ztt.designMode.A_singleMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/21 14:21
 */
public class HungrySingleton {

    private static final HungrySingleton instance=new HungrySingleton();

    private String name = "3";

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
