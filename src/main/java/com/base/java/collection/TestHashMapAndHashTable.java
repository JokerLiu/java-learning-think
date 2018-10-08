package com.base.java.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

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
         */

        Map<String, Object> map = new HashMap<>();

        Hashtable<String, Object> hashTable = new Hashtable<>();


        new A();

    }

}

// class A {
//
//     private final String val;
//
//     public A() {
//         this.val = null;
//     }
//
//     public A(String val) {
//         this();
//         this.val = val;
//     }
// }

class A {

    private final String val;

    public A() {
        this("asd");
    }

    public A(String val) {
        this.val = val;
    }
}