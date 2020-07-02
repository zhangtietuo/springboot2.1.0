package com.ztt.designMode.factoryMode;

/**
 * @Auther: zhangtietuo
 * @Description: 发型工厂 ===========>类的反射原理
 * @Date: 2019/1/15 14:41
 */
public class HairFactory {

    /**
     * 普通方法
     *
     * @param key
     * @return
     */
    public HairInterface getHair(String key) {
        if ("left".equals(key)) {
            HairInterface leftHair = new LeftHair();
            return leftHair;
        } else if ("right".equals(key)) {
            HairInterface rightHair = new RightHair();
            return rightHair;
        } else {
            return null;
        }

    }

    /**
     * 反射方法
     *
     * @param key
     * @return
     */
    public HairInterface getHairByClass(String className) {
        try {
            HairInterface hair = (HairInterface) Class.forName(className).newInstance();
            return hair;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
