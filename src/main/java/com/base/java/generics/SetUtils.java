package com.base.java.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/7/16 15:13
 */
public class SetUtils {

    /**
     * @return
     * @Description 取并集
     * @Author Joker
     * @Date 2018/9/25 19:35
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    /**
     * @Description 去交集
     * @return 
     * @Author Joker
     * @Date 2018/9/25 19:36
     */
    public static <T> Set<T> interSection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * @Description
     * @return 
     * @Author Joker
     * @Date 2018/9/25 19:39
     */
    public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet) {
        Set<T> result = new HashSet<>(superSet);
        result.removeAll(subSet);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), interSection(a, b));
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        Set<Integer> newSet = SetUtils.union(set1, set2);
        System.out.println("union:" + newSet);
        newSet = SetUtils.interSection(set1, set2);
        System.out.println("interSection:" + newSet);
        newSet = SetUtils.difference(set1, set2);
        System.out.println("difference:" + newSet);
        newSet = SetUtils.complement(set1, set2);
        System.out.println("complement:" + newSet);
    }
}
