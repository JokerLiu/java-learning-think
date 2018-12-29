package com.interview.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程顺序执行
 *
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/12/29 15:17
 */
@Slf4j
public class Q1ThreadSequentialit02 {

    static Thread thread01 = new Thread(new Runnable() {
        @Override
        public void run() {
            log.info("thread01...running...");
        }
    });

    static Thread thread02 = new Thread(() -> log.info("thread02...running..."));

    static Thread thread03 = new Thread(() -> log.info("thread03...running..."));

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args){
        // FIFO
        executorService.submit(thread01);
        executorService.submit(thread02);
        executorService.submit(thread03);
        executorService.shutdown();
    }

}