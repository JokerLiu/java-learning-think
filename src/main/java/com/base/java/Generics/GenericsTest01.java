package com.base.java.Generics;

import java.util.Collection;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/7/16 14:32
 */
public class GenericsTest01 {

    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static void main(String[] args) {

    }
}
