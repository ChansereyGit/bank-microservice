package com.serey.bank.account.controller;

import com.serey.bank.account.dto.CustomerDTO;
import com.serey.bank.account.entity.Customer;
import com.serey.bank.account.mapper.CustomerMapper;
import com.serey.bank.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.toCustomer(customerDTO);
        customerService.save(customer);
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomers(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getById(customerId));
    }
}
