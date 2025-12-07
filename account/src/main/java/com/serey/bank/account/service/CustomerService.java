package com.serey.bank.account.service;

import com.serey.bank.account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> getCustomers();

    Customer getById(Long customerId);

}
