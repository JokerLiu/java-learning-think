package com.base.java.juc.producer_and_consumer;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Joker
 * @Description: 生产者消费者
 * @Date: Created in 2018/9/28 14:29
 */
public class Test01 {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer pro = new Producer(clerk);
        Consumer cus = new Consumer(clerk);

        new Thread(pro, "生产者 A").start();
        new Thread(cus, "消费者 B").start();

        // new Thread(pro, "生产者 C").start();
        // new Thread(cus, "消费者 D").start();
    }

}

/**
 * @Description 店员
 * @return
 * @Author Joker
 * @Date 2018/9/28 14:32
 */
@Slf4j
class Clerk {
    private int product = 1;

    public synchronized void get() throws InterruptedException {
        while (product >= 1) {
            log.info("产品容量已满！");
            this.wait();
        }
        log.info("当前产品数量{}", ++product);
        this.notifyAll();
    }

    public synchronized void sale() throws InterruptedException {
        while (product <= 0) {
            log.info("缺货！");
            this.wait();
        }

        log.info("当前产品数量{}", --product);
        this.notifyAll();
    }
}

/**
 * @Description 生产者
 * @return
 * @Author Joker
 * @Date 2018/9/28 14:31
 */
class Producer implements Runnable {

    private Clerk clerk;

    Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
                clerk.get();
            } catch (InterruptedException e) {
            }
        }
    }
}

/**
 * @Description 消费者
 * @return
 * @Author Joker
 * @Date 2018/9/28 14:31
 */
class Consumer implements Runnable {

    private Clerk clerk;

    Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
                clerk.sale();
            } catch (InterruptedException e) {
            }
        }
    }
}