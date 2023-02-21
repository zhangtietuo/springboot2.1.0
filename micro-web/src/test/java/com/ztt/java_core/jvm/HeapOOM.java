package com.ztt.java_core.jvm;


import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author zzm
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        int i = 0;
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            i++;
            System.out.println(i);
            list.add(new OOMObject());
        }
    }
}