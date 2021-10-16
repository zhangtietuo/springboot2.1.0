package com.ztt.designMode.E_BuilderMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2020/7/6 14:02
 */
public class Product {

    private String partA;

    private String partB;

    private String partC;

    public void setPartA(String partA) {
        this.partA=partA;
    }

    public void setPartB(String partB) {
        this.partB=partB;
    }

    public void setPartC(String partC) {
        this.partC=partC;
    }

    public void show() {
        //显示产品的特性
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}
