package com.base.java.collection;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/29 9:42
 */
public class TestHashMap {

    public static void main(String[] args) {

        // Map<String, Object> map = new HashMap<>();

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