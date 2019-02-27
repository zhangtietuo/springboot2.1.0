package com.ztt.java_core;

import java.util.HashMap;
import java.util.Map;


/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/9 14:20
 */
public class HashMapDemo {

    public static void main(String[] args) {
        hash("zzz");
        Map<String, String> map = new HashMap<>();
        map.put("zzz", "123");
    }

    static final int hash(Object key) {
        int h;
        if(key == null) {
            return 0;
        } else {
            h = key.hashCode();
            int result = h ^ (h >>> 16);
            return result;
        }
    }
}
