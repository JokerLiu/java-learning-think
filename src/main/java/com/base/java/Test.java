package com.base.java;

/**
 * @program: springbootdemo
 * @description:
 * @author: Joker
 * @create: 2018-08-28 17:48
 **/
public class Test {

    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());

        new A();
    }

}

// class A {
//
//     private final String val;
//
//     public A() {
//         this.val = null;
//     }
//
//     public A(String val) {
//         this();
//         this.val = val;
//     }
// }

class A {

    private final String val;

    public A() {
        this("asd");
    }

    public A(String val) {
        this.val = val;
    }

}