package com.base.java.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/28 15:38
 */
public class TestLock {

    public static void main(String[] args) {
        Ticket t = new Ticket();

        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }

}

@Slf4j
class Ticket implements Runnable {

    private int ticket = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticket > 0) {
                    sleep(200);
                    log.info("售票成功...当前余票：{}", --ticket);
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        // while (true) {
        //     //lock.lock();
        //     try {
        //         if (ticket > 0) {
        //             sleep(200);
        //             log.info("售票成功...当前余票：{}", --ticket);//超卖
        //         } else {
        //             break;
        //         }
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     } finally {
        //         //lock.unlock();
        //     }
        // }
    }
}