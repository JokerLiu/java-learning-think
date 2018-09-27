package com.base.java.enumdemo;

/**
 * @Author: Joker
 * @Description: 一个参数枚举类
 * @Date: Created in 2018/7/13 15:54
 */
public enum EnumOneArgs {
    // 通过构造函数传递参数并创建实例
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");
    // 通过构造函数传递参数并创建实例
    private EnumOneArgs(String msg) {
        this.msg = msg;
    }
    // 通过构造函数传递参数并创建实例
    private String msg;
    // 通过构造函数传递参数并创建实例
    public String getMsg() {
        return msg;
    }
}
