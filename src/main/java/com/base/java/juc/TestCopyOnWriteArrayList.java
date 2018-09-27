package com.base.java.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/27 15:42
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        CopyOnWriteArrayListDemo copy = new CopyOnWriteArrayListDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(copy).start();
        }
    }
}

@Slf4j
class CopyOnWriteArrayListDemo implements Runnable {

    // 线程不安全，在多线程并发下，读写操作throw new ConcurrentModificationException();
    // private static List<String> list = new ArrayList<>();

    // 添加操作多时，效率低，因为每次添加时都会进行复制，开销非常的大。并发迭代操作多时可以选择。
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            log.info("" + it.next());

            list.add("DD");
        }
    }
}
