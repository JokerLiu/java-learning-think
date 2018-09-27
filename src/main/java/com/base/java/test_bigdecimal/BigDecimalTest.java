package com.java.bigdecimalTest;

import java.math.BigDecimal;

/**
 * @program: springbootdemo
 * @description:
 * @author: Joker
 * @create: 2018-08-27 10:23
 **/
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal ONE_HUNDRED = new BigDecimal(100);
        BigDecimal fenZi = new BigDecimal(0);
        BigDecimal fenMu = new BigDecimal(4); // 如果把4改成5或者>5的数字，则程序运行正常
        System.out.println(fenMu.divide(ONE_HUNDRED, 1, BigDecimal.ROUND_HALF_UP));
        BigDecimal result = fenZi.divide(fenMu.divide(ONE_HUNDRED, 1, BigDecimal.ROUND_HALF_UP), 1, BigDecimal.ROUND_HALF_UP);
        System.out.println("result: " + result.toPlainString());


        BigDecimal d1 = new BigDecimal(0.6);
        BigDecimal d2 = new BigDecimal(0.4);
        System.out.println(d1);
        System.out.println(d2);
        BigDecimal d3 = d1.divide(d2);
        // Exception in thread "main" java.lang.ArithmeticException: Non-terminating decimal expansion;
        // no exact representable decimal result.
        System.out.println(d3);

        BigDecimal d4 = new BigDecimal("0.6");
        BigDecimal d5 = new BigDecimal("0.4");
        BigDecimal d6 = d4.divide(d5);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(d6);

        BigDecimal b2 = BigDecimal.valueOf(1.34);//1.34
    }
}
