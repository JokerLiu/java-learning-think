package com.base.java.learnjava8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/18 15:36
 */
public class TestStreamMap {

    public static void main(String[] args) {
        //test01();
        test02();

    }

    public static void test01() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(toList());
        squares.forEach(System.out::println);
    }

    public static void test02() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> squares = numbers1.stream()
                .flatMap(n1 -> numbers2.stream().map(n2 -> new int[]{n1, n2}))
                .collect(toList());

        squares.forEach(b -> System.out.println(b[0] + "------" + b[1]));
    }

}
