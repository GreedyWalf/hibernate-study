package com.test2;

import com.qs.entity.Account;
import com.qs.entity.Address;
import com.qs.service.AccountService;
import com.qs.service.impl.AccountServiceImpl;
import com.qs.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


public class TestOptionRelation {
    private static AccountService accountService;

    static {
        accountService = new AccountServiceImpl();
    }

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
     * 具有主外键关系的表数据保存（先保存副表address，在保存主表account）
     */
    @Test
    public void save() {
        Session session = HibernateUtils.getSession();

        Address address = new Address();
        address.setAddressName("安徽省合肥市包河区滨湖翰林院");
        session.save(address);

        Account account = new Account();
        account.setAccountName("qinyupeng");
        account.setSex("man");
        account.setAge(25);
        account.setMobile("15856999769");
        account.setEmail("qinyupeng@qgutech.com");
        account.setPassword("qin123456");
        account.setAddress(address);

        Transaction tx = null;
        if (session != null) {
            try {
                tx = session.beginTransaction();
                session.save(account);
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (tx != null) {
                    tx.rollback();
                }
            }
        }
    }
}
