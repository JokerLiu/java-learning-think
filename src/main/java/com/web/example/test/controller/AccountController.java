package com.example.test.controller;

import com.example.test.entity.Account;
import com.example.test.entity.TestBuilder;
import com.example.test.entity.TestLombok1;
import com.example.test.service.IAccountService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @ClassName: AccountController
 * @Description: springbootdemo
 * @author: liuyl
 * @date: 2018/4/21 14:27
 */
@Api(description = "SpringJDBC实现CRUD")
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }

    @GetMapping(value = "/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccountById(id);
    }

    @PutMapping(value = "/{id}")
    public String updateAccount(@PathVariable("id") int id,
                                @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t = accountService.update(account);
        if (t == 1) {
            return account.toString();
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        int t = accountService.add(account);
        if (t == 1) {
            return account.toString();
        } else {
            return "fail";
        }
    }

    public static void main(String[] args) {
        // 使用@Builder @Getter注解之后可以通过类.builder().code("000000").message("测试使用build方法构造对象").build()链式方法调用
        TestBuilder tb = TestBuilder.builder().code("000000").message("测试使用build方法构造对象").build();
        System.out.println(tb);

        TestLombok1 tl = new TestLombok1().setId("123").setName("234").setComment("123");
        System.out.println(tl);
        tl.setId("213").setName("aaa").setComment("zxc123");
        System.out.println(tl);
    }
}