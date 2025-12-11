package com.serey.bank.account.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountDTO {
    // accountNumber is auto-generated, don't include in create request
    private Long customerId;
    private String accountType;
    private String branchAddress;
    private LocalDate createDate;
}
