package com.base.java.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Joker
 * @create: 2018-08-28 10:15
 * <p>
 * 一、volatile 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见
 * 1. volatile 不具备“互斥性”
 * 2. volatile 不能保证变量的“原子性”
 *
 * volatile 关键字就是用于保证内存可见性，当线程A更新了 volatile 修饰的变量时，
 * 它会立即刷新到主线程，并且将其余缓存中该变量的值清空，导致其余线程只能去主内存读取最新值。
 * 使用 volatile 关键词修饰的变量每次读取都会得到最新的数据，不管哪个线程对这个变量的修改都会立即刷新到主内存。
 **/
@Slf4j
public class TestVolatile {

    public static void main(String[] args) {
        TestThread tt = new TestThread();
        new Thread(tt).start();

        while (true) {
            if (tt.isFlag()) {
                log.info("-------------------------");
                break;
            }
        }
    }

}

@Slf4j
class TestThread implements Runnable {

    private volatile boolean flag = false;// 使用volatile修饰变量，使得变量在多个线程之间可见

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        flag = true;
        log.info("flag = {}", isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
