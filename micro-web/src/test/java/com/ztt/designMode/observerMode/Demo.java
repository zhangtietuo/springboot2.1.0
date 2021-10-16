package com.ztt.designMode.observerMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/14 18:02
 */
public class Demo {

    public static void main(String[] args) {
        ConcreateObserver observer1 = new ConcreateObserver();
        observer1.setObserverName("ztt");
        ConcreateObserver observer2 = new ConcreateObserver();
        observer2.setObserverName("ldh");
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.attach(observer1);
        concreteSubject.attach(observer2);
        concreteSubject.setState("今天天气晴朗");
    }
}
