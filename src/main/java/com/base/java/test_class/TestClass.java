package com.base.java.test_class;

import java.lang.reflect.Method;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/10/9 15:17
 */
public class TestClass {

    public static void main(String[] args) {

        TestA a = new TestA();

        //第一种表达方式
        Class c1 = TestA.class;//这种表达方式同时也告诉了我们任何一个类都有一个隐含的静态成员变量class
        //第二种表达方式
        Class c2 = a.getClass();//这种表达方式在已知了该类的对象的情况下通过getClass方法获取
        //第三种表达方式
        Class c3 = null;
        try {
            c3 = Class.forName("com.base.java.test_class.TestA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //true 这表明不论c1 or c2 or c3都代表了F类的类类型，也就是说一个类只可能是Class类的一个实例对象。
        System.out.println(c1 == c2 && c2 == c3);

        TestA a1 = null;
        try {
            a1 = (TestA) c1.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Class d1 = int.class;//int 的类类型
        Class d2 = String.class;//String类的类类型
        Class d3 = void.class;
        System.out.println(d1.getName());
        System.out.println(d2.getName());
        System.out.println(d2.getSimpleName());
        System.out.println(d3.getName());

    }

}

class TestA {

}

class ClassUtil {

    public static void printClassMethodMessage(Object obj) {
        //要获取类的信息》》首先我们要获取类的类类型
        Class c = obj.getClass();

        //我们知道Object类是一切类的父类，所以我们传递的是哪个子类的对象，c就是该子类的类类型。
        //接下来我们要获取类的名称
        System.out.println("类的名称是:" + c.getName());
        /*
         *我们知道，万事万物都是对象，方法也是对象，是谁的对象呢？
         * 在java里面，方法是Method类的对象
         *一个成员方法就是一个Method的对象，那么Method就封装了对这个成员
         *方法的操作
         */
        //如果我们要获得所有的方法，可以用getMethods()方法，这个方法获取的是所有的Public的函数，包括父类继承而来的。如果我们要获取所有该类自己声明的方法，就可以用getDeclaredMethods()方法，这个方法是不问访问权限的。
        Method[] ms = c.getMethods();//c.getDeclaredMethods()
        //接下来我们拿到这些方法之后干什么？我们就可以获取这些方法的信息，比如方法的名字。
        //首先我们要循环遍历这些方法
        for (int i = 0; i < ms.length; i++) {
            //然后可以得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            //得到方法的返回值类型的名字
            System.out.print(returnType.getName() + " ");
            //得到方法的名称
            System.out.print(ms[i].getName() + "(");
            //获取参数类型--->得到的是参数列表的类型的类类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }
}
