package com.ztt.designMode.H_BridgeMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/6 17:26
 */
public class RefinedAbstraction extends Abstraction {

    protected RefinedAbstraction(Implementor imple) {
        super(imple);
    }

    @Override
    public void Operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问" );
        imple.operationImpl();
    }
}
