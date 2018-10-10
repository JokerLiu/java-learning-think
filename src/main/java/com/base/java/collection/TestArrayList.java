package com.base.java.collection;

import java.util.ArrayList;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/10/10 16:21
 */
public class TestArrayList {
    private static ArrayList<Integer> longArrayList = new ArrayList<>();

    static {
        longArrayList.add(1);
        longArrayList.add(2);
        longArrayList.add(3);
        longArrayList.add(4);
    }

    public static void main(String[] args) {
        /**
         * Exception in thread "main" java.util.ConcurrentModificationException
         * 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
         * 	at java.util.ArrayList$Itr.next(ArrayList.java:859)
         * 	for each循环本质是对List进行迭代器循环，ArrayList内部类Itr实现Iterator接口
         * 	public Iterator<E> iterator() {
         *      return new Itr();
         *  }
         *  迭代器遍历ArrayList其实本质和指针很像，观察源码可以知道，使用了游标来记录当前遍历的位置
         *  public E next() {
         *      checkForComodification();
         *      int i = cursor;
         *      if (i >= size)
         *          throw new NoSuchElementException();
         *      Object[] elementData = ArrayList.this.elementData;
         *      if (i >= elementData.length)
         *          throw new ConcurrentModificationException();
         *      cursor = i + 1;
         *      return (E) elementData[lastRet = i];
         *  }
         *  在每次遍历时，会对当前对象长度改变进行检查。
         *  final void checkForComodification() {
         *      if (modCount != expectedModCount)
         *          throw new ConcurrentModificationException();
         *  }
         *  当遍历时对当前ArrayList进行了增删的操作，则会抛出ConcurrentModificationException异常。
         */
        for (Integer s : longArrayList) {
            longArrayList.remove(s);
        }
    }

}