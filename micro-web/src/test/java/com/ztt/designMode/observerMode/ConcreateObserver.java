package com.ztt.designMode.observerMode;

/**
 * @Auther: zhangtietuo
 * @Description: 具体的观察者对象，实现更新方法，使自身状态和目标状态保持一致
 * @Date: 2019/1/14 16:17
 */
public class ConcreateObserver implements Observer {

    private String observerState;

    private String observerName;

    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject)subject).getState();
        System.out.println(observerName+"收到了"+observerState+"讯息"+("ztt".equals(observerName)?"你吹牛逼最棒":"你唱歌真好听"));
    }

    public String getObserverState() {
        return observerState;
    }

    public void setObserverState(String observerState) {
        this.observerState = observerState;
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }
}
