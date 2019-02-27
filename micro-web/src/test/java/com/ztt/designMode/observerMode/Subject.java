package com.ztt.designMode.observerMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhangtietuo
 * @Description: 目标对象，它知道观察它的观察者，并提供注册和删除观察者的接口
 * @Date: 2019/1/14 16:14
 */
public class Subject {

    //保存注册的观察者对象
    private List<Observer> observerList = new ArrayList<>();

    public void attach(Observer observer) {
        this.observerList.add(observer);
    }

    public void detach(Observer observer) {
        this.observerList.remove(observer);
    }

    protected void notifyObservers() {
        for(Observer observer: observerList) {
            observer.update(this);
        }
    }
}
