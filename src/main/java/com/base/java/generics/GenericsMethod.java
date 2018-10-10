package com.base.java.generics;

/**
 * @Author: Joker
 * @Description: 泛型方法
 * 使用泛型类是需要在穿件对象的时候指定具体类型参数的值，使用泛型方法时不需要指定参数类型，
 * 因为编译期会找出具体类型：这一过程称为类型推断
 * @Date: Created in 2018/7/16 11:38
 */
public class GenericsMethod {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericsMethod gm = new GenericsMethod();
        gm.f(" ");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0f);
        gm.f('c');
        gm.f(gm);
        /*
        java.lang.String
        java.lang.Integer
        java.lang.Double
        java.lang.Float
        java.lang.Character
        com.java.generics.GenericsMethod
        */
    }
}
