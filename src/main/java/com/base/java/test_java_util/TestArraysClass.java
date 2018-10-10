package com.base.java.test_java_util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/20 10:05
 */
public class TestArraysClass {

    public static void main(String[] args) {
        String str = "123,121,454,8,7,454,65456,454654,5645645645646548,4564564,7897,2432,12313214";

        List<Long> list = Arrays.stream(str.split(","))
                .map(s -> Long.parseLong(s.trim())).sorted((o1, o2) -> (int) (o1 - o2)).collect(Collectors.toList());
        System.out.println(list.size());
        for (Long s : list) {
            System.out.println(s);
        }

        /**
         * @Description Arrays.asList();方法返回的是Arrays的内部静态类，继承了AbstractList。因此调用的是AbstractList的add方法；
         * @return java.lang.UnsupportedOperationException
         * @Author Joker
         * @Date 2018/10/9 17:34
         */
        String[] strArr = "as|sd|dd".split("\\|");
        List<String> lists = Arrays.asList(strArr);
        lists.add("a");
        System.out.println(lists);
        lists.hashCode();

        Integer[] nums1 = new Integer[]{1, 2, 3, 4, 5, 6};
        List list1 = Arrays.asList(nums1);
        list1.set(0, 888);
        System.out.println(list1);
    }

}
