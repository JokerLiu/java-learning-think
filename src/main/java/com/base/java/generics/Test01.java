package com.base.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/8/31 16:05
 */
public class Test01 {

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        /*
         * 类型擦除
         * */
        System.out.println(l1.getClass() == l2.getClass());// true

    }

}
