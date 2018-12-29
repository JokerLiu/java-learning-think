package com.interview.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/12/29 16:28
 */
public class Q3LockAndSynchronized {
    /*
    Synchronized：
    什么时候释放锁？
        1.获取锁的线程执行完了该代码块
        2.获取锁的线程执行发生了异常
    缺陷：
        被动释放锁
        读写锁不分离
    Lock：
    什么时候释放锁？
        1.lock.lock()
        2.lock.unlock()
    有点：
        主动释放锁
        读写锁分离
    */
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        test();
        lock.unlock();
    }

    public static void test(){

    }
}
