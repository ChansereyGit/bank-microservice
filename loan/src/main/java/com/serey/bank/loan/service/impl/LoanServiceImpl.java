package com.serey.bank.loan.service.impl;

import com.serey.bank.loan.entity.Loan;
import com.serey.bank.loan.repository.LoanRepository;
import com.serey.bank.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getList() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> findByCustomerId(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }
}
