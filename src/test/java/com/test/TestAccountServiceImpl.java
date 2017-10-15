package com.test;

import com.qs.entity.Account;
import com.qs.service.AccountService;
import com.qs.service.impl.AccountServiceImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import java.util.List;

public class TestAccountServiceImpl {
    private static AccountService accountService;

    static {
        accountService = new AccountServiceImpl();
    }


    //创建生成表
    @Test
    public void test(){
        Configuration cfg = new Configuration().configure();
        SchemaExport se = new SchemaExport(cfg);
        se.create(true,true);
    }

    @Test
    public void Add(){
        Account account = new Account();
        account.setAccountId("111111");
        account.setAccountName("zhangsan");
        account.setPassword("123");
        account.setAge(20);
        account.setEmail("695830237@qq.com");
        account.setSex("男");
        account.setMobile("15856999769");
        accountService.addAccount(account);
    }


    @Test
    public void update(){
        Account account = new Account();
        account.setAccountId("402880ea5f1bd7f3015f1bd7f7660000");
        account.setAccountName("修改后的名字");
        accountService.updateAccount(account);
    }

    @Test
    public void getSingle(){
        Account account = accountService.getSingle("402880ea5f1bd7f3015f1bd7f7660000");
        System.out.println(account.getAccountId());
        System.out.println(account.getAccountName());
    }

    @Test
    public void testGetAll(){
        List<Account> accountList = accountService.getAllAccount();
        System.out.println("--->>" + accountList.size());
    }
}
