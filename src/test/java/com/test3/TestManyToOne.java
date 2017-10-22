package com.test3;

import com.qs.entity.Account;
import com.qs.entity.Address;
import com.qs.entity.Department;
import com.qs.service.AccountService;
import com.qs.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestManyToOne {

    @Test
    public void createTable(){
        Configuration cfg = new Configuration().configure();
        SchemaExport se = new SchemaExport(cfg);
        se.create(true,true);
    }

    /**
     * 具有主外键关系的表数据保存（先保存副表address，在保存主表account）
     */
    @Test
    public void save() {
        Session session = HibernateUtils.getSession();
        Transaction tx = session.beginTransaction();

        Address address = new Address();
        address.setAddressName("李鸿章故居");
        session.save(address);

        Address address2 = new Address();
        address2.setAddressName("朱元璋故居");
        session.save(address2);

        //保存部门数据
        Account account = new Account();
        account.setAccountName("qinyupeng");
        account.setSex("man");
        account.setAge(25);
        account.setMobile("15856999769");
        account.setEmail("qinyupeng@qgutech.com");
        account.setPassword("qin123456");
        account.setAddress(address);
        session.save(account);

        Account account2 = new Account();
        account2.setAccountName("qinyupeng2");
        account2.setSex("man");
        account2.setAge(25);
        account2.setMobile("15856999769");
        account2.setEmail("qinyupeng@qgutech.com");
        account2.setPassword("qin123456");
        account2.setAddress(address2);

        Set<Account> accountList = new HashSet<Account>();
        accountList.add(account);
        accountList.add(account2);

        Department department = new Department("研发部");
        department.setUsers(accountList);
        session.save(department);

        session.save(account2);
        tx.commit();
    }
}
