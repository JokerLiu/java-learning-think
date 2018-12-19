package com.base.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用linkedHashMap实现
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/12/19 14:04
 */
public class LRUCacheWithLinkedHashMap extends LinkedHashMap<Object, Object> {

    protected int maxElements;

    public LRUCacheWithLinkedHashMap(int maxSize) {
        super(maxSize, 0.75F, true);
        this.maxElements = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
        return (size() > this.maxElements);
    }

    public static void main(String[] args) {
        LRUCacheWithLinkedHashMap map = new LRUCacheWithLinkedHashMap(3);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        System.out.println(map);// {1=1, 2=2, 3=3}
        map.get("1");
        map.get("3");
        System.out.println(map);// {2=2, 1=1, 3=3}
        map.put("4","4");
        System.out.println(map);// {1=1, 3=3, 4=4}
    }

}