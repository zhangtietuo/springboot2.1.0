package com.ztt.java_core;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/1/9 14:20
 */
public class HashMapDemo {

    public static void main(String[] args) {
        hash("zzz");
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        map.put("k5", "v5");
        map.put("k6", "v6");
        map.put("k7", "v7");
        map.put("k8", "v8");
        map.put("k9", "v9");
        map.put("k10", "v10");
        map.put("k11", "v11");
        map.put("k12", "v12");
        map.put("k13", "v13");
        /*============================================================================*/
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("k1", "v1");
        concurrentHashMap.put("k2", "v2");
        concurrentHashMap.put("k3", "v3");
        concurrentHashMap.put("k4", "v4");
        concurrentHashMap.put("k5", "v5");
        concurrentHashMap.put("k6", "v6");
        concurrentHashMap.put("k7", "v7");
        concurrentHashMap.put("k8", "v8");
        concurrentHashMap.put("k9", "v9");
        concurrentHashMap.put("k10", "v10");
        concurrentHashMap.put("k11", "v11");
        concurrentHashMap.put("k12", "v12");
        concurrentHashMap.put("k13", "v13");
        /*============================================================================*/
        Map<String, String> hashtable = new Hashtable<>();
        hashtable.put("k1", "v1");
        hashtable.put("k2", "v2");
        hashtable.put("k3", "v3");
        hashtable.put("k4", "v4");
        hashtable.put("k5", "v5");
        hashtable.put("k6", "v6");
        hashtable.put("k7", "v7");
        hashtable.put("k8", "v8");
        hashtable.put("k9", "v9");
        hashtable.put("k10", "v10");
        hashtable.put("k11", "v11");
        hashtable.put("k12", "v12");
        hashtable.put("k13", "v13");
    }

    static final int hash(Object key) {
        int h;
        if (key == null) {
            return 0;
        } else {
            h = key.hashCode();
            int result = h ^ (h >>> 16);
            return result;
        }
    }
}
