package com.serey.bank.account.service.impl;

import com.serey.bank.account.entity.Customer;
import com.serey.bank.account.repository.CustomerRepository;
import com.serey.bank.account.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long customerId) {
        return customerRepository
                .findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }


}
