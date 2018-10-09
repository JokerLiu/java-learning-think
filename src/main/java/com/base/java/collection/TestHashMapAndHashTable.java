package com.base.java.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/29 9:42
 */
public class TestHashMapAndHashTable {

    public static void main(String[] args) {
        /**
         * 1.HashMap实现了Map、Cloneable、Serializable，继承AbstractMap
         *  Hashtable实现了Map、Cloneable、Serializable，继承Dictionary（已被废弃）
         *  从公开的方法上来看，这两个类提供的，是一样的功能。
         *  都提供键值映射的服务，可以增、删、查、改键值对，可以对建、值、键值对提供遍历视图。支持浅拷贝，支持序列化
         * 2.HashMap是支持null键和null值的，而HashTable在遇到null时，会抛出NullPointerException异常。
         * 3.线程安全：
         *  HashMap是线程不安全的。而HashTable是线程安全的，类中的方法全部使用了synchronized修饰了
         */
        // Map<String, Object> map = new HashMap<>();

        Hashtable<String, Object> hashTable = new Hashtable<>();

        /**
         * ConcurrentHashMap基于concurrentLevel划分出了多个Segment来对key-value进行存储，从而避免每次锁定整个数组，
         * 在默认的情况下，允许16个线程并发无阻塞的操作集合对象，尽可能地减少并发时的阻塞现象。
         *
         * ConcurrentHashMap中的方法使用了Lock来解决并发访问问题。
         * JDK1.7中，使用了锁分段技术来解决并发问题。
         * JDK1.8中，使用CAS算法优化。
         */
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }
}

/**
 * @Description 计算数组中出现次数最多的那个数字，利用了hashMap的特性
 * @return
 * @Author Joker
 * @Date 2018/10/9 17:44
 */
class CalculateArrayMostNumber {

    private int[] a = {2, 3, 2, 2, 1, 4, 2, 2, 2, 7, 9, 6, 2, 2, 3, 1, 0};

    public void cal(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int anA : a) {
            if (map.containsKey(anA)) {
                int tmp = map.get(anA);
                tmp += 1;
                map.put(anA, tmp);
            } else {
                map.put(anA, 1);
            }
        }

        Set<Integer> set = map.keySet();//------------1------------
        for (Integer s : set) {
            if (map.get(s) >= a.length / 2) {
                System.out.println(s);
            }
        }
    }

}