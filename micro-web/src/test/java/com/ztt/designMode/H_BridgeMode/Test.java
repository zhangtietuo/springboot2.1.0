package com.ztt.designMode.H_BridgeMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/6 17:29
 */
public class Test {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Implementor imple=new ObjectAdapter(adaptee);
        Abstraction abs=new RefinedAbstraction(imple);
        abs.Operation();
    }
}
