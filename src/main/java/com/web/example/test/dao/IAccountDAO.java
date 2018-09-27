package com.example.test.dao;

import com.example.test.entity.Account;

import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */
public interface IAccountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
