package com.qs.service;

import com.qs.entity.Account;

import java.util.List;

public interface AccountService {

    boolean addAccount(Account account);

    boolean updateAccount(Account account);

    boolean delete(Account account);

    Account getSingle(String accountId);

    List<Account> getAllAccount();
}
