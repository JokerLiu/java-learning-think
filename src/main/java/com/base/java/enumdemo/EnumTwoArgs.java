package com.base.java.enumdemo;

/**
 * @Author: Joker
 * @Description: 两个参数枚举
 * @Date: Created in 2018/7/13 16:00
 */
public enum EnumTwoArgs {
    // 通过构造函数传递参数并创建实例
    SPRING(1, "spring"),

    SUMMER(2, "summer"),

    AUTUMN(3, "autumn"),

    WINTER(4, "winter");

    // 定义实例对应的参数
    private Integer key;
    private String msg;

    // 必写：通过此构造器给枚举值创建实例
    EnumTwoArgs(Integer key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    // 很多情况，我们可能从前端拿到的值是枚举类的 key ，然后就可以通过以下静态方法获取到对应枚举值
    public static EnumTwoArgs valueOfKey(Integer key) {
        for (EnumTwoArgs season : EnumTwoArgs.values()) {
            if (season.key.equals(key)) {
                return season;
            }
        }
        throw new IllegalArgumentException("No element matches " + key);
    }

    // 通过此方法可以获取到对应实例的 key 值
    public Integer getKey() {
        return key;
    }

    // 通过此方法可以获取到对应实例的 msg 值
    public String getMsg() {
        return msg;
    }
}
