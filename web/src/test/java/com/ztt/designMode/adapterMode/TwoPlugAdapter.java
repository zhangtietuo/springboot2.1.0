package com.ztt.designMode.adapterMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/16 13:38
 */
public class TwoPlugAdapter implements ThreePlugIf {

    private GBTwoPlug gbTwoPlug;

    public TwoPlugAdapter(GBTwoPlug gbTwoPlug) {
        this.gbTwoPlug = gbTwoPlug;
    }

    @Override
    public void powerWithThree() {
        System.out.println("通过转换");
        gbTwoPlug.powerWithTwo();
    }
}
