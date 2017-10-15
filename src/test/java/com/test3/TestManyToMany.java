package com.test3;

import com.qs.entity.Account;
import com.qs.entity.Role;
import com.qs.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestManyToMany {

    /**
     * 创建生成表
     */
    @Test
    public void test(){
        Configuration cfg = new Configuration().configure();
        SchemaExport se = new SchemaExport(cfg);
        se.create(true,true);
    }


    /**
     * 保存用户和角色数据分别到：t_account、t_role、t_account_role表中
     */
    @Test
    public void testMany(){
        Role role = new Role("系统管理员");
        Role role2 = new Role("培训管理员");

        Account account = new Account();
        account.setAccountName("admin");
        account.setMobile("10086");
        account.setPassword("123");
        account.setSex("woman");
        account.getRoles().add(role);
        account.getRoles().add(role2);

        Account account2 = new Account();
        account2.setAccountName("trainAdmin");
        account2.setMobile("110");
        account2.setPassword("123");
        account2.setSex("man");
        account2.getRoles().add(role2);

        Session session = HibernateUtils.getSession();
        Transaction tx = session.beginTransaction();
        session.save(account);
        session.save(account2);
        tx.commit();
    }
}
