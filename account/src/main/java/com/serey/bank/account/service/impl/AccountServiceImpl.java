package com.serey.bank.account.service.impl;

import com.serey.bank.account.entity.Account;
import com.serey.bank.account.repository.AccountRepository;
import com.serey.bank.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Long customerId) {
        return accountRepository
                .findById(customerId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
