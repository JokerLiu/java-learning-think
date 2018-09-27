package com.example.test.service.impl;

import com.example.test.dao.IAccountDAO;
import com.example.test.entity.Account;
import com.example.test.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @ClassName: AccountServiceImpl
 * @Description: springbootdemo
 * @author: liuyl
 * @date: 2018/4/21 14:26
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDAO accountDAO;

    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDAO.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDAO.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDAO.findAccountList();
    }
}
