package com.base.java.jvm;

import java.util.Random;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/12/7 12:26
 */
public class PrintGCDetailsTest {

    public static void main(String[] args) {
        /*
         [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4623K->4623K(7680K), 0.0004335 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         [Full GC (Allocation Failure)
         发生Java heap space之前的一定是FullGC 当持久代空间的对象无法被回收时，便报Java heap space
         Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
          */
        String str = "asd";
        while (true) {
            str += str + new Random().nextInt(99999999) + new Random().nextInt(88888888);
        }

    }

}