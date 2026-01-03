package com.serey.bank.loan.service;

import com.serey.bank.loan.entity.Loan;

import java.util.List;

public interface LoanService {

    Loan save(Loan loan);
    List<Loan> getList();
    List<Loan> findByCustomerId(Long customerId);

}
