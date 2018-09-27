package com.base.java.enumdemo;

/**
 * @Author: Joker
 * @Description: 枚举类测试类
 * @Date: Created in 2018/7/13 15:53
 */
public class EnumTest {
    public static void main(String[] args) {
        // 无参枚举
        EnumNoArgs enumNoArgs = EnumNoArgs.SPRING;
        System.out.println(EnumNoArgs.SPRING); // SPRING
        System.out.println(enumNoArgs.toString());// SPRING

        // 单个参数枚举
        EnumOneArgs enumOneArgs = EnumOneArgs.SPRING;
        System.out.println(EnumNoArgs.SPRING); // SPRING
        System.out.println(enumNoArgs.toString());// SPRING
        String enumOneArgsMsg = enumOneArgs.getMsg();
        System.out.println(enumOneArgsMsg);// 春天
        System.out.println(EnumOneArgs.SPRING.getMsg());// 春天

        // 两个参数枚举
        EnumTwoArgs enumTwoArgs ;
        System.out.println(EnumTwoArgs.valueOfKey(1));// SPRING
        System.out.println(EnumTwoArgs.valueOfKey(1).getKey());// 1
        System.out.println(EnumTwoArgs.valueOfKey(1).getMsg());// spring
    }
}
