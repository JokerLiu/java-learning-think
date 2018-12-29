package com.interview.concurrency;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程顺序执行
 *
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/12/29 15:17
 */
@Slf4j
public class Q1ThreadSequentialit01 {

    static Thread thread01 = new Thread(new Runnable() {
        @Override
        public void run() {
            log.info("thread01...running...");
        }
    });

    static Thread thread02 = new Thread(() -> log.info("thread02...running..."));

    static Thread thread03 = new Thread(() -> log.info("thread03...running..."));

    public static void main(String[] args) throws InterruptedException {
        /*
        线程随机执行
        thread01.start();
        thread02.start();
        thread03.start();
        */
        /*
        * 线程按顺序执行
        * */
        thread01.start();
        // -> Thread:join(0); -> Thread:wait(0); -> Object:native void wait(long timeout);
        // 即最终调用的main线程的 wait()方法，主线程会等待thread01执行完之后在往下执行
        thread01.join();
        thread02.start();
        thread02.join();
        thread03.start();
        thread03.join();

        /*
        Exception in thread "main" java.lang.IllegalThreadStateException
            at java.lang.Thread.start(Thread.java:708)
            at com.interview.concurrency.Q1ThreadSequentiality.main(Q1ThreadSequentiality.java:28)
            线程实例调用start()方法之后，实例属性threadStatus != 0;
        for (int i = 0; i < 10; i++) {
            thread01.start();
            thread02.start();
            thread03.start();
        }
        */
    }

}