package com.java.annotation;

import java.util.Objects;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/7/16 10:04
 */
public class OverrideAnno {
    private String s1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OverrideAnno that = (OverrideAnno) o;
        return Objects.equals(s1, that.s1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s1);
    }
    //@Override
    //public boolean equals(OverrideAnno o1,OverrideAnno o2) {
    //    return true;
    //}

    //public boolean equals(OverrideAnno overrideAnno) {
    //    return true;
    //}

    public static void main(String[] args) {
        /*
        * 由于所有类都隐式继承Object类，OverrideAnno类的目的是覆盖Object.equals()方法
        * 因此OverrideAnno可被测试是否与Java中的任何其他对象相等。*/
        Object foo = new OverrideAnno();
        Object identicalFoo = new OverrideAnno();
        System.out.println(foo.equals(identicalFoo));// false 依旧调用Object.equals()方法，而不会调用OverrideAnno类的equals()方法
    }
}
