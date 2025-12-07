package com.serey.bank.account.controller;

import com.serey.bank.account.dto.AccountDTO;
import com.serey.bank.account.entity.Account;
import com.serey.bank.account.mapper.AccountMapper;
import com.serey.bank.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody AccountDTO accountDTO) {
        Account account = accountMapper.toAccount(accountDTO);
        accountService.save(account);
        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<?> getAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping("{accountId}")
    public ResponseEntity<?> getAccount(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getById(accountId));
    }
}
