package com.base.java;

import java.util.Arrays;
import java.util.List;

/**
 * @program: springbootdemo
 * @description:
 * @author: Joker
 * @create: 2018-08-28 17:48
 **/
public class Test {

    public static void main(String[] args) {

        // List<Long> list = Arrays.stream(str.split(","))
        //         .map(s -> Long.parseLong(s.trim())).sorted((o1, o2) -> (int) (o1 - o2)).collect(Collectors.toList());
        //
        // System.out.println(list.size());
        //
        // for (Long s : list) {
        //     System.out.println(s);
        // }

        String[] strArr = "as|sd|dd".split("\\|");
        List<String> list = Arrays.asList(strArr);
        list.add("a");
        System.out.println(list);

        for (String s : strArr) {
            System.out.println(s);
        }
        list.hashCode();


    }

}