package com.serey.bank.account.service;

import com.serey.bank.account.entity.Account;

import java.util.List;


public interface AccountService {
    Account save(Account account);

    List<Account> getAccounts();

    Account getById(Long accountId);
}
