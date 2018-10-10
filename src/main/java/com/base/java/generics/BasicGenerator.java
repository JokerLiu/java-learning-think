package com.base.java.generics;

/**
 * @Author: Joker
 * @Description: 通过泛型和反射机制，实现创建泛型容器工厂来生成对象
 * @Date: Created in 2018/7/16 14:40
 */
public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }
}
