package com.base.java.jvm;

/**
 * 栈溢出
 *
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/12/7 11:12
 */
public class OverflowStackTest {

    private static void run() {
        run(); //Exception in thread "main" java.lang.StackOverflowError
    }

    public static void main(String[] args) {
        run();
        System.out.println("1");
    }
}