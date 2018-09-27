package com.web.example.mybatis.service;

import com.web.example.mybatis.dao.AccountMapper;
import com.web.example.mybatis.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @ClassName: IAccountService
 * @Description: springbootdemo
 * @author: liuyl
 * @date: 2018/4/21 14:25
 */
@Component
public class MybatisAccountService {
    @Autowired
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }

    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }

    public int delete(int id) {
        return accountMapper.delete(id);
    }

    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }

    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }
}
