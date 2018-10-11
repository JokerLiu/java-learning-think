package com.base.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Joker
 * @Description:可变参数与泛型方法
 * @Date: Created in 2018/7/16 14:01
 */
public class GenericsVarargs {
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<T>();
        for (T item : args)
            result.add(item);
        return result;
    }

    @SafeVarargs //程序员断言，带注释的方法或构造函数的主体不会对其varargs参数执行可能不安全的操作 可能产生不安全的操作
    public static <T> List<T> makeList1(T... args) {
        return new ArrayList<T>(Arrays.asList(args));
    }

    public static void main(String[] args) {
        List<String> list = GenericsVarargs.makeList1("A");
        System.out.println(list);
        list = GenericsVarargs.makeList1("A","B","C");
        System.out.println(list);
        list = GenericsVarargs.makeList1("ABCDEFG".split(" "));
        System.out.println(list);
        /*
         [A]
         [A, B, C]
         [ABCDEFG]
         * */
    }
}
