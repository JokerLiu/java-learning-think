package com.base.java.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Joker
 * @Description: 闭锁，在完成某些运算是，只有其他所有线程的运算全部完成，当前运算才继续执行
 * @Date: Created in 2018/9/27 18:18
 */
@Slf4j
public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);// 初始默认值为5（此处的初始值为线程数量）
        CountDownLatchDemo latchDemo = new CountDownLatchDemo(latch);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();
        }
        latch.await();// 如果latch不为0，则等待
        long end = System.currentTimeMillis() - start;

        log.info("总共花费 {} 毫秒", end);
    }

}

@Slf4j
class CountDownLatchDemo implements Runnable {

    private CountDownLatch countDownLatch;

    CountDownLatchDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                if (i % 2 == 0) {
                    log.info("{}", i);
                }
            }
        } finally {
            countDownLatch.countDown();// 执行完初始值-1
        }
    }
}