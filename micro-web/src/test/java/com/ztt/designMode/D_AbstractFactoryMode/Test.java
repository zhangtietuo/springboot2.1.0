package com.ztt.designMode.D_AbstractFactoryMode;


import com.ztt.designMode.E_BuilderMode.Builder;

/**
 * @Auther: zhangtietuo
 * @Description: 感受protected的修饰范围
 * @Date: 2020/7/6 14:03
 */
public class Test {

    public static void main(String[] args) {
        Builder builder = new Builder() {
            @Override
            public void buildPartA() {

            }

            @Override
            public void buildPartB() {

            }

            @Override
            public void buildPartC() {

            }
        };
        //builder.product();

    }

}
