package com.base.java.jvm;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/12/7 11:24
 */
public class OutOfMemoryTest {

    public static void main(String[] args) {

        long maxMemory = Runtime.getRuntime().maxMemory();// jvm试图使用的内存量
        long totalMemory = Runtime.getRuntime().totalMemory();// jvm最大使用的内存量

        System.out.println(maxMemory / 1024 / 1024);// 3612 虚拟机默认占用机器的1/4内存
        System.out.println(totalMemory / 1024 / 1024);// 3612 虚拟机默认占用机器的1/4内存

        /**
         * -Xms1000M 虚拟机初始内存大小 -Xmx1000M 虚拟机最大占用 虚拟器内存配置 由于进制转换，所以初始内存实际大小为958
         * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
         * @param: [args]
         * @return: void
         * @author: Joker
         * @date: 2018/12/7 11:29
         */
        // byte[] bytes = new byte[1024 * 1024 * 1000];// 申请1000M的内存

    }

}
