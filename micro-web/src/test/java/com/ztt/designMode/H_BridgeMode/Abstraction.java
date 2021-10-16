package com.ztt.designMode.H_BridgeMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/6 17:25
 */
public abstract class Abstraction {

    protected Implementor imple;
    protected Abstraction(Implementor imple)
    {
        this.imple=imple;
    }
    public abstract void Operation();
}
