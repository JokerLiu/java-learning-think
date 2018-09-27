package com.base.java.gof.adapter;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/26 14:17
 * <p>
 * 以下情况比较适合使用 Adapter 模式：
 * 1.当你想使用一个已经存在的类，而它的接口不符合你的需求；
 * 2.你想创建一个可以复用的类，该类可以与其他不相关的类或不可预见的类协同工作；
 * 3.你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口，对象适配器可以适配它的父亲接口。
 */
public class Client {

    public static void main(String[] args) {
        //创建需要被适配的对象
        Adaptee adaptee = new Adaptee();
        //创建客户端需要调用的接口对象
        Target target = new Adapter(adaptee);
        //请求处理
        target.request();
    }

}
