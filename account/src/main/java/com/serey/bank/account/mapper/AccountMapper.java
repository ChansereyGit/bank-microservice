package com.serey.bank.account.mapper;

import com.serey.bank.account.dto.AccountDTO;
import com.serey.bank.account.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toAccount(AccountDTO dto) {
        Account account = new Account();
        // Don't set accountNumber - it's auto-generated
        account.setAccountType(dto.getAccountType());
        account.setBranchAddress(dto.getBranchAddress());
        account.setCreateDate(dto.getCreateDate());
        //account.setCustomerId(dto.getCustomerId());
        return account;
    }
}