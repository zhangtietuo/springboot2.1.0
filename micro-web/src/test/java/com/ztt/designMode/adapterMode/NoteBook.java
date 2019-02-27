package com.ztt.designMode.adapterMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/16 10:25
 */
public class NoteBook {

    private ThreePlugIf plug;

    public NoteBook(ThreePlugIf plug) {
        this.plug = plug;
    }

    public void charge() {
        plug.powerWithThree();
    }
}
