package com.serey.bank.card.service;

import com.serey.bank.card.entity.Loan;

import java.util.List;

public interface LoanService {

    Loan save(Loan loan);
    List<Loan> getList();
    List<Loan> findByCustomerId(Long customerId);

}
