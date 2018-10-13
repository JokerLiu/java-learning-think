package com.web.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 本地缓存类
 * 目前考虑的是占用了JVM的heap区域，再细化一点的就是heap中的old区，目前的数据量来看，都是一些小数据，加起来没有几百兆，放在heap区域最快最方便。
 * 后期如果需要放置在本地缓存的数据大的时候，可以考虑在off-heap区域（direct-memory 或者 big-memory），
 * 但是off-heap区域的话，需要考虑对象的序列化（因为off-heap区域存储的是二进制的数据），另外一个的话就是off-heap的GC问题。
 * 其实，如果真的数据量比较大，那其实就可以考虑搞一个集中式的缓存系统，可以是单机，也可以是集群，来承担缓存的作用。
 * https://blog.csdn.net/mik1s/article/details/53580303
 *
 * @package com.example.utils
 * @auther joker
 * @date 2018/6/4 14:10
 */
public class LocalCache {

    //缓存Map
    private static Map<String, CacheContent> map = new HashMap<>();
    private static LocalCache localCache = new LocalCache();

    private LocalCache() {
    }

    public String getLocalCache(String key) {
        CacheContent cc = new CacheContent();
        // map.get(key);

        if (null == cc) {
            return null;
        }

        long currentTime = System.currentTimeMillis();

        if (cc.getCacheMillis() > 0 && currentTime - cc.getCreateTime() > cc.getCacheMillis()) {
            //超过缓存过期时间,返回null
            // map.remove(key);
            return null;
        } else {
            return cc.getElement();
        }
    }

    public void setLocalCache(String key, int cacheMillis, String value) {
        long currentTime = System.currentTimeMillis();
        CacheContent cc = new CacheContent(cacheMillis, value, currentTime);
        // map.put(key, cc);
    }

    public static LocalCache getInStance() {
        return localCache;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class CacheContent {
        // 缓存生效时间
        private int cacheMillis;
        // 缓存对象
        private String element;
        // 缓存创建时间
        private long createTime;
    }

}