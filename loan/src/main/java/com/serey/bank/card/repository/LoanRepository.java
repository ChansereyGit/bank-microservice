package com.serey.bank.card.repository;

import com.serey.bank.card.entity.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LoanRepository extends MongoRepository<Loan, String> {
    List<Loan> findByCustomerId(Long customerId);
}
