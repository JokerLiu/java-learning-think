package com.base.java.classload;

import com.base.java.reflect.TestReflect;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/11/20 17:51
 */
public class Test {

    public static void main(String[] args) {
        /* 应用程序类加载器（application class loader）
        它根据 Java 应用的类路径（classpath， java.class.path 路径下的内容）来加载 Java 类。
        一般来说，Java 应用的类都是由它来完成加载的。
        – 由sun.misc.Launcher$AppClassLoader实现 */
        TestClassLoader classLoader = new TestClassLoader();
        System.out.println(classLoader.getParent());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader.getParent().getParent());//sun.misc.Launcher$ExtClassLoader@6d03e736


        // 退出虚拟机：code = 123
        // System.exit(123);

        System.out.println(ClassLoader.getSystemClassLoader());

        try {
            //Thread.sleep(2000);
            Class<?> testReflect = classLoader.loadClass("com.base.java.reflect.TestReflect");
            TestReflect reflect = (TestReflect) testReflect.newInstance();
            System.out.println(reflect.initStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int i = 129;
        System.out.println(i);

    }

}
