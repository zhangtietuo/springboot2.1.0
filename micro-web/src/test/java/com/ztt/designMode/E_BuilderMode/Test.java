package com.ztt.designMode.E_BuilderMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/6 14:06
 */
public class Test {

    public static void main(String[] args) {
        Builder builder=new Concrete1Builder();
        Director director=new Director(builder);
        Product product=director.construct();
        product.show();
        builder=new Concrete2Builder();
        director=new Director(builder);
        product=director.construct();
        product.show();
    }
}
