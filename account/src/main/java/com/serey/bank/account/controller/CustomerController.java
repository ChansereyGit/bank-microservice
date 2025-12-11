package com.serey.bank.account.controller;

import com.serey.bank.account.dto.CardResponseDTO;
import com.serey.bank.account.dto.CustomerDTO;
import com.serey.bank.account.dto.CustomerDetailDTO;
import com.serey.bank.account.dto.LoanResponseDTO;
import com.serey.bank.account.entity.Customer;
import com.serey.bank.account.mapper.CustomerMapper;
import com.serey.bank.account.service.CustomerService;
import com.serey.bank.account.service.client.CardFeignClient;
import com.serey.bank.account.service.client.LoanFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CardFeignClient cardFeignClient;

    @Autowired
    private LoanFeignClient loanFeignClient;

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

    @GetMapping("/customerDetail/{customerId}")
    public ResponseEntity<CustomerDetailDTO> getCustomerDetail(@PathVariable Long customerId) {
        CustomerDetailDTO dto = new CustomerDetailDTO();
        Customer customer = customerService.getById(customerId);
        if(customer == null) {
            throw new RuntimeException("Customer not found with this ID");
        }
        CustomerDTO customerDTO = customerMapper.toCustomerDTO(customer);
        List<LoanResponseDTO> loanInfo = loanFeignClient.getLoanInfo(customerId);
        List<CardResponseDTO> cardInfo = cardFeignClient.getCardInfo(customerId);
        dto.setCustomer(customerDTO);
        dto.setLoans(loanInfo);
        dto.setCards(cardInfo);

        return ResponseEntity.ok(dto);
    }
}
