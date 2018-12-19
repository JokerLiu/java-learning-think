package com.base.algorithm.lru;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/12/19 14:23
 */
public class LRUCacheWithGuava {

    public static void main(String[] args) {

        Cache<Object, Object> builder = CacheBuilder.newBuilder().maximumSize(3).initialCapacity(3).build();
        builder.put(1, 1);
        builder.put(2, 2);
        builder.put(3, 3);
        System.out.println(builder.asMap());// {3=3, 2=2, 1=1}
        builder.getIfPresent(2);
        builder.getIfPresent(3);
        System.out.println(builder.asMap());// {3=3, 2=2, 1=1}
        builder.put(4,4);
        System.out.println(builder.asMap());// {3=3, 2=2, 4=4}
    }
}