package com.ztt.designMode.A_singleMode;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/21 14:21
 */
public class LazySingleton {

    private static volatile LazySingleton instance=null;    //volatile保证 instance 在所有线程中同步
    private LazySingleton(){}    //private 避免类在外部被实例化
    public static synchronized LazySingleton getInstance()
    {
        //getInstance 方法前加同步
        if(instance==null)
        {
            instance=new LazySingleton();
        }
        return instance;
    }

}
