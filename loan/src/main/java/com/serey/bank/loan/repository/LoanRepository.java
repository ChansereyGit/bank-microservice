package com.serey.bank.loan.repository;

import com.serey.bank.loan.entity.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LoanRepository extends MongoRepository<Loan, String> {
    List<Loan> findByCustomerId(Long customerId);
}
