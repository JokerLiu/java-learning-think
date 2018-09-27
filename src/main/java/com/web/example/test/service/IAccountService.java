package com.example.test.service;

import com.example.test.entity.Account;

/*
 * @ClassName: IAccountService
 * @Description: springbootdemo
 * @author: liuyl
 * @date: 2018/4/21 14:25
 */
public interface IAccountService {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    java.util.List<Account> findAccountList();
}
