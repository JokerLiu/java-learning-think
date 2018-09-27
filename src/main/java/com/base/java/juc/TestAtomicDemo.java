package com.base.java.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/26 10:39
 * <p>
 * <p>
 * noAtomicDemo:
 * 17:06:33.617 [Thread-7] INFO com.base.java.juc.NoAtomicDemo - NoAtomicDemo : serialNumber = 4
 * 17:06:33.617 [Thread-0] INFO com.base.java.juc.NoAtomicDemo - NoAtomicDemo : serialNumber = 0
 * 17:06:33.617 [Thread-2] INFO com.base.java.juc.NoAtomicDemo - NoAtomicDemo : serialNumber = 0
 * 17:06:33.617 [Thread-1] INFO com.base.java.juc.NoAtomicDemo - NoAtomicDemo : serialNumber = 1
 * 17:06:33.617 [Thread-9] INFO com.base.java.juc.NoAtomicDemo - NoAtomicDemo : serialNumber = 2
 * 17:06:33.618 [Thread-4] INFO com.base.java.juc.NoAtomicDemo - NoAtomicDemo : serialNumber = 7
 * 17:06:33.618 [Thread-3] INFO com.base.java.juc.NoAtomicDemo - NoAtomicDemo : serialNumber = 8
 * 17:06:33.617 [Thread-8] INFO com.base.java.juc.NoAtomicDemo - NoAtomicDemo : serialNumber = 3
 * 17:06:33.617 [Thread-6] INFO com.base.java.juc.NoAtomicDemo - NoAtomicDemo : serialNumber = 5
 * 17:06:33.618 [Thread-5] INFO com.base.java.juc.NoAtomicDemo - NoAtomicDemo : serialNumber = 6
 */
@Slf4j
public class TestAtomicDemo {

    public static void main(String[] args) {

        NoAtomicDemo noAtomicDemo = new NoAtomicDemo();
        AtomicDemo atomicDemo = new AtomicDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(noAtomicDemo).start();
        }
        log.info("=========================================================================");
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }

    }

}

@Slf4j
class NoAtomicDemo implements Runnable {

    /* 一、i++ 的原子性问题：i++ 的操作实际上分为三个步骤“读-改-写”
     * 		  int i = 10;
     * 		  i = i++; //10
     *
     * 		  int temp = i;
     * 		  i = i + 1;
     * 		  i = temp;
     */
    private volatile int serialNumber = 0;

    public int getSerialNumber() {
        return serialNumber++;
    }

    @Override
    public void run() {
        try {
            sleep(200);
        } catch (InterruptedException e) {
            log.info("唤醒异常：{}", e.getMessage());
        }
        log.info("NoAtomicDemo : serialNumber = " + getSerialNumber());
    }

}

@Slf4j
class AtomicDemo implements Runnable {
    /*
     * 二、原子变量：在 java.util.concurrent.atomic 包下提供了一些原子变量。
     * 1. volatile 保证内存可见性
     * 2. CAS（Compare-And-Swap） 算法保证数据变量的原子性
     * CAS 算法是硬件对于并发操作的支持
     * CAS 包含了三个操作数：
     * ①内存值  V
     * ②预估值  A
     * ③更新值  B
     * 当且仅当 V == A 时， V = B; 否则，不会执行任何操作。
     * volatile 关键字就是用于保证内存可见性，当线程A更新了 volatile 修饰的变量时，它会立即刷新到主线程，并且将其余缓存中该变量的值清空，导致其余线程只能去主内存读取最新值。
        使用 volatile 关键词修饰的变量每次读取都会得到最新的数据，不管哪个线程对这个变量的修改都会立即刷新到主内存。
        synchronized和加锁也能能保证可见性，实现原理就是在释放锁之前其余线程是访问不到这个共享变量的。但是和 volatile 相比开销较大
     */
    private AtomicInteger serialNumber = new AtomicInteger(0);

    public int getSerialNumber() {

        return serialNumber.getAndIncrement();
    }

    @Override
    public void run() {
        try {
            sleep(200);
        } catch (InterruptedException e) {
            log.info("唤醒异常：{}", e.getMessage());
        }
        log.info("AtomicDemo : serialNumber = " + getSerialNumber());
    }

}