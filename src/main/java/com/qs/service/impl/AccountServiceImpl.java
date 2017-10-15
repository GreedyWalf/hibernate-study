package com.qs.service.impl;

import com.qs.entity.Account;
import com.qs.service.AccountService;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private static SessionFactory sessionFactory;
    private static Session session;

    static {
        try {
            Configuration cfg = new Configuration().configure();
            sessionFactory = cfg.buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    private static Session getSession() {
        return sessionFactory.openSession(); //过去老的方法，不需要使用事务
        // 新的方法，需要和事务一起使用，可以保证每个用户创建的session独立，需要在配置<property name="current_session_context_class">thread</property>
        //return sessionFactory.getCurrentSession();
    }


    public boolean addAccount(Account account) {
        boolean b = false;
        Session session = getSession();
        if (session != null) {
            Transaction tx = null;
            try {
                //开启一个事务
                tx = session.beginTransaction();
                //保存
                session.save(account);
                //提交事务
                tx.commit();
                b = true;
            } catch (Exception e) {
                e.printStackTrace();
                if (tx != null) {
                    tx.rollback();
                }
            }
        }

        return b;
    }

    public boolean updateAccount(Account account) {
        boolean b = false;
        Transaction tx = null;
        Session session = getSession();
        if (session != null) {
            try {
                //开启一个事务
                tx = session.beginTransaction();
                //保存
                Account accountFromDB = (Account) session.load(Account.class, account.getAccountId());
                //更新某个属性
                accountFromDB.setAccountName(account.getAccountName());

                //提交事务
                tx.commit();
                b = true;
            } catch (Exception e) {
                e.printStackTrace();
                if (tx != null) {
                    tx.rollback();
                }
            }
        }

        return b;
    }

    public boolean delete(Account account) {
        boolean b = false;
        Transaction tx = null;
        Session session = getSession();
        if (session != null) {
            try {
                //开启一个事务
                tx = session.beginTransaction();

                //获取数据中的实体对象
                Account accountFromDB = (Account) session.load(Account.class, account.getAccountId());
                //删除操作
                session.delete(accountFromDB);

                //提交事务
                tx.commit();
                b = true;
            } catch (Exception e) {
                e.printStackTrace();
                if (tx != null) {
                    tx.rollback();
                }
            }
        }

        return b;
    }

    public Account getSingle(String accountId) {
        Account account = null;
        Transaction tx = null;
        Session session = getSession();
        if (session != null) {
            try {
                //开启事务
                tx = session.beginTransaction();
                account = (Account) session.load(Account.class, accountId);
                //事务提交
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (tx != null) {
                    tx.rollback();
                }
            } finally {
                //这里不能将session关闭，关闭后会出现异常（hibernate框架会维护这个session，他会在你事务提交的时候关闭session。）
//                session.close();
            }
        }

        return account;
    }

    public List<Account> getAllAccount() {
        List<Account> accountList = null;
        try {
            Session session = getSession();
            if (session != null) {
                String hql = "from Account";
                Query query = session.createQuery(hql);
                accountList = query.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return accountList;
    }
}
