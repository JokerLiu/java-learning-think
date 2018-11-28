package com.base.java.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/11/19 18:10
 */
@Slf4j
public class TestReflect {

    public String initStr = "asd";

    private Integer age;

    private String name;

    static
    {
        System.out.println("Tester类的静态初始化块...");
    }



    void classLoadM(Integer age){
        this.age = age;
    }

    void classLoadM(String name){
        this.name = name;
    }

    void classLoadM(Integer age,String name){
        this.age = age;
    }

    public static void main(String[] args) {
        Class<TestReflect> clz = TestReflect.class;
        Method[] declaredMethods = clz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            log.debug("method:{}", method.getName());
            System.out.println("----------------------------------");
        }


    }
}
