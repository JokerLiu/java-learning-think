package com.base.java.gof.adapter;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/26 14:16
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
