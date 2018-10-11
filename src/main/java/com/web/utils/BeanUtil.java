package com.web.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;


/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/10/11 10:05
 */
public class BeanUtil {

    /**
     * @return
     * @Description 获取目标对象中为Null的属性值
     * @Author Joker
     * @Date 2018/9/15 14:33
     */
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * @return
     * @Description 拷贝bean，忽略源bean的null属性。
     * @Author Joker
     * @Date 2018/9/19 18:02
     */
    private static void copyPropertiesIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

}
