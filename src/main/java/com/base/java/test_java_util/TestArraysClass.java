package com.base.java.test_java_util;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/9/20 10:05
 */
public class TestArraysClass {

    public static void main(String[] args) {
        Integer[] nums1 = new Integer[]{1, 2, 3, 4, 5, 6};
        List list1 = Arrays.asList(nums1);
        list1.set(0, 888);
        System.out.println(list1);

        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6};
        int[] nums3 = new int[]{1, 2, 3, 4, 5, 6};

        List<int[]> list2 = Arrays.asList(nums2);
        list2.set(0, nums3);
        int[] nums4 = (int[]) list2.get(0);
        for (int i : nums4) {
            System.out.println(i);
        }
        System.out.println();
    }

}
