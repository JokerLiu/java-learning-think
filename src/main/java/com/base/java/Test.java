package com.base.java;

/**
 * @program: springbootdemo
 * @description:
 * @author: Joker
 * @create: 2018-08-28 17:48
 **/
public class Test {

    public static void main(String[] args) {

        int x = 1;
        x <<= 4;// 位移运算后赋值给变量
        System.out.println(x);

        // 左移运算
        int a = 1 << 30;
        int b = 1 << 4;
        int c = 3 << 4;// 3 -> 二进制表示： 11


        System.out.println(Integer.toBinaryString(a));// 二进制： 1000000000000000000000000000000
        System.out.println(Integer.toBinaryString(b));// 二进制： 10000
        System.out.println(Integer.toBinaryString(c));// 二进制： 110000

        // 右移运算
        int a1 = a >> 30;// 1
        int b1 = b >> 4;// 1
        int c1 = c >> 4;// 3

        System.out.println(Integer.toBinaryString(a1));// 二进制： 1
        System.out.println(Integer.toBinaryString(b1));// 二进制： 1
        System.out.println(Integer.toBinaryString(c1));// 二进制： 11

        // 无符号右移运算
        int a2 = a >>> 30;// 1
        int b2 = b >>> 4;// 1
        int c2 = c >>> 4;// 3

        System.out.println(Integer.toBinaryString(a2));
        System.out.println(Integer.toBinaryString(b2));
        System.out.println(Integer.toBinaryString(c2));

        // List<Long> list = Arrays.stream(str.split(","))
        //         .map(s -> Long.parseLong(s.trim())).sorted((o1, o2) -> (int) (o1 - o2)).collect(Collectors.toList());
        //
        // System.out.println(list.size());
        //
        // for (Long s : list) {
        //     System.out.println(s);
        // }

        // String[] strArr = "as|sd|dd".split("\\|");
        // List<String> list = Arrays.asList(strArr);
        // list.add("a");
        // System.out.println(list);
        //
        // for (String s : strArr) {
        //     System.out.println(s);
        // }
        // list.hashCode();


    }

}