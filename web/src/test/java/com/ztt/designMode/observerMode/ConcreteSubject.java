package com.ztt.designMode.observerMode;

/**
 * @Auther: zhangtietuo
 * @Description: 具体的目标对象，负责把有关状态存入相应的观察者对象中
 * @Date: 2019/1/14 16:15
 */
public class ConcreteSubject extends Subject {

    //目标对象的状态
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        this.notifyObservers();
    }
}
