package com.web.utils;

import java.math.BigDecimal;

/**
 * @program: springbootdemo
 * @description:
 * @author: Joker
 * @create: 2018-08-27 10:30
 **/
public class BigDecimalUtils {

    /**
     * @param bd  商品的价格
     * @param num 保留几位小数,如num = 2
     * @return
     */
    public static String formatPrice(BigDecimal bd, int num) {
        if (bd == null || num < 0) {
            return null;
        }
        bd = bd.setScale(num, BigDecimal.ROUND_HALF_UP);
        return bd + "";
    }

    /**
     * 元转换为分
     *
     * @param bd 商品的价格
     * @return
     */
    public static String yuanToCent(BigDecimal bd) {
        if (bd == null) {
            return null;
        }
        bd = bd.multiply(new BigDecimal(100))
                .setScale(0, BigDecimal.ROUND_HALF_EVEN);// 表示采用"四舍五入"的模式处理价格,并且结果不保留小数.
        return bd + "";
    }

}
