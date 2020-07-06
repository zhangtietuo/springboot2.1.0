package com.ztt.designMode.H_BridgeMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/6 17:32
 */
public class ObjectAdapter extends Concrete1Implementor {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void operationImpl() {
        adaptee.operationImpl();
    }
}
