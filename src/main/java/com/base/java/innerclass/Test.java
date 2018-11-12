package com.base.java.innerclass;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/11/9 15:22
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        TestInnerClass.StaticInnerClass ts = new TestInnerClass.StaticInnerClass();

        TestInnerClass tss = TestInnerClass.createBuilder().setName("a1").setAdress("asd").build();

        System.out.println(tss);

        Entity entity = Entity.builder().address("asdasdas").id(456456L).name("张三").build();
        System.out.println(entity.toString());

    }

}
