package com.base.java.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/27 14:53
 */
@Slf4j
public class TestCompareAndSwap {

    public static void main(String[] args) {
        final CompareAndSwapDemo cas = new CompareAndSwapDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expectedValue = cas.getValue();
                log.info("初始值：{}", expectedValue);
                boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
                log.info("替换：{}", b);
            }).start();
        }

        // 模拟CAS
        // for (int i = 0; i < 10; i++) {
        //     new Thread(() -> {
        //         boolean b = true;
        //         while (b) {
        //             int expectedValue = cas.getValue();
        //             log.info("初始值：" + expectedValue);
        //             b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
        //             log.info("替换：" + b);
        //         }
        //     }).start();
        // }
    }
}

@Slf4j
class CompareAndSwapDemo {

    private int value;

    public int getValue() {
        return value;
    }

    synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;

        if (oldValue == expectedValue) {
            this.value = newValue;
        }

        return oldValue;
    }

    synchronized boolean compareAndSet(int expectedValue, int newValue) {
        log.info("期望值：{}  新值：{}", expectedValue, newValue);
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }

}