package com.web.example.mybatis.entity;

import lombok.Data;
import lombok.ToString;

/*
 * @ClassName: Account
 * @Description: springbootdemo
 * @author: liuyl
 * @date: 2018/4/21 14:22
 */
@Data
@ToString
public class Account {
    private int id;
    private String name;
    private double money;
}
