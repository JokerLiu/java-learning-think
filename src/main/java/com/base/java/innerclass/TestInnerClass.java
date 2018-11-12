package com.base.java.innerclass;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Author: Joker
 * @Description: 内部类学习
 * @Date: Created in 2018/11/9 15:09
 */
@Slf4j
@Data
public class TestInnerClass {

    private String name;
    private Integer age;
    private String phone;
    private String adress;
    private String he;

    public int publicInt = 0;

    public static int publicStaticInt = 0;

    public TestInnerClass() {
        log.info("【TestInnerClass Construct】------------------>");

        PublicInnerClass p = new PublicInnerClass();
        p.privateInt = 1;

    }

    private TestInnerClass(StaticInnerClass staticInnerClass) {
        log.info("【TestInnerClass Construct】------------------>");
        setName(staticInnerClass.name);
        setAge(staticInnerClass.age);
        PublicInnerClass p = new PublicInnerClass();
        p.privateInt = 1;
    }

    public static StaticInnerClass createBuilder(){
        return new StaticInnerClass();
    }

    /**
     * public 内部类
     */
    public class PublicInnerClass {

        private int privateInt = 0;

        /**
         * 只能访问外部类的静态成员变量
         */
        public PublicInnerClass() {
            log.info("【PublicInnerClass Construct】------------------>");
            log.info("【PublicInnerClass privateInt】------------------>{}", privateInt);
        }
    }

    /**
     * private 静态内部类
     */
    private class PrivateInnerClass {
        private int privateInt = 0;
    }

    /**
     * 静态内部类
     */
    public static class StaticInnerClass {

        public StaticInnerClass setName(String name) {
            this.name = name;
            return this;
        }

        public StaticInnerClass setAge(Integer age) {
            this.age = age;
            return this;
        }

        public StaticInnerClass setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public StaticInnerClass setAdress(String adress) {
            this.adress = adress;
            return this;
        }

        public StaticInnerClass setHe(String he) {
            this.he = he;
            return this;
        }

        private String name;
        private Integer age;
        private String phone;
        private String adress;
        private String he;

        private int privateInt = 0;

        /**
         * 只能访问外部类的静态成员变量
         */
        void set() {
            privateInt = TestInnerClass.publicStaticInt;
        }

        TestInnerClass build(){
            return new TestInnerClass(this);
        }

    }

    /**
     * 抽象内部类
     */
    public abstract class AbstractInnerClass {
        private int privateInt = 0;
    }

    /**
     * 静态抽象内部类
     */
    public static abstract class StaticAbstractInnerClass {
        private int privateInt = 0;
    }

    /**
     * 静态抽象内部类 实现接口
     */
    public static abstract class StaticAbstractInnerClassImpl implements Map {
        private int privateInt = 0;
    }

    /**
     * 外部类可以访问内部类的所有方法与属性，包括私有方法与属性。
     */
    public static void main(String[] args) {
        // TestInnerClass ts = TestInnerClass.StaticInnerClass.;
        // PublicInnerClass pic = ts.new PublicInnerClass();
    }

}