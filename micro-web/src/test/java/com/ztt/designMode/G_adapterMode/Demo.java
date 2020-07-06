package com.ztt.designMode.G_adapterMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/16 13:34
 */
public class Demo {

    public static void main(String[] args) {
        GBTwoPlug two = new GBTwoPlug();
        ThreePlugIf three = new TwoPlugAdapter(two);
        NoteBook noteBook = new NoteBook(three);
        noteBook.charge();
    }
}
