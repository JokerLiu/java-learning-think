package com.base.java.learnjava8;

import java.util.Optional;

/**
 * 思考：调用一个方法得到了返回值却不能直接将返回值作为参数去调用别的方法。
 * 原来解决方案：我们首先要判断这个返回值是否为null，只有在非空的前提下才能将其作为其他方法的参数。
 * 这正是一些类似Guava的外部API试图解决的问题。一些JVM编程语言比如Scala、Ceylon等已经将对在核心API中解决了这个问题。
 *
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/11/9 17:58
 */
public class TestOptional {

    //调用工厂方法创建Optional实例
    public static Optional<String> name = Optional.of("Sanaulla");
    //传入参数为null，抛出NullPointerException.
    // Optional<String> someNull = Optional.of(null);
    public static Optional<String> someNull = Optional.ofNullable(null);

    public static boolean assertBoolean() {
        return someNull.isPresent();
    }

    public static void main(String[] args) {
        System.out.println(TestOptional.name.isPresent() ? TestOptional.name.get() : "");
        System.out.println(TestOptional.name.orElse(""));

        System.out.println(TestOptional.assertBoolean());
    }

}
