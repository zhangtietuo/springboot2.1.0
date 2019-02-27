package com.ztt.designMode.observerMode;

/**
 * @Auther: zhangtietuo
 * @Description: 观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 * @Date: 2019/1/14 16:16
 */
public interface Observer {

    //更新接口
    void update(Subject subject);
}
