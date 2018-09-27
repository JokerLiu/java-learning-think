package com.web.example.mybatis.controller;

import com.web.example.mybatis.entity.Account;
import com.web.example.mybatis.service.MybatisAccountService;
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
@Api(description = "mybatis实现CRUD")
@Slf4j
@RestController
@RequestMapping("/mybatis")
public class MybatisController {
    @Autowired
    private MybatisAccountService accountService;

    @GetMapping(value = "/list")
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }

    @GetMapping(value = "/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccount(id);
    }

    @PutMapping(value = "/{id}")
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        int t = accountService.update(name, money, id);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }

    }

    @GetMapping(value = "getSomething")
    public String getSomething(){
        return  "789";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        int t = accountService.delete(id);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }

    }

    @PostMapping(value = "")
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {

        int t = accountService.add(name, money);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }

    }
}