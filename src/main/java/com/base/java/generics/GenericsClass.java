package com.base.java.generics;

/**
 * @Author: Joker
 * @Description:泛型类
 * @Date: Created in 2018/7/16 11:25
 */
public class GenericsClass<T> {
    private T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public GenericsClass(){
    }

    public GenericsClass(T a){
        this.a = a;
    }

    public static void main(String[] args) {
        GenericsClass<Test> gt1 = new GenericsClass<>();
        GenericsClass<Test> gt2 = new GenericsClass<>(new Test());
        GenericsClass<Object> gt3 = new GenericsClass<>(new Object());

        GenericsClass<Test> g1 = new GenericsClass<Test>();
    }
}

class Test{

}