package com.serey.bank.loan.controller;

import com.serey.bank.loan.dto.LoanDTO;
import com.serey.bank.loan.entity.Loan;
import com.serey.bank.loan.mapper.LoanMapper;
import com.serey.bank.loan.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private LoanMapper loanMapper;

    @PostMapping
    public ResponseEntity<?> saveLoan(@RequestBody LoanDTO dto) {
        Loan loan = loanService.save(loanMapper.toLoan(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(loan);
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanService.getList());
    }

    @GetMapping("{customerId}")
    public ResponseEntity<?> getByCustomerId(
            @RequestHeader("sereybank-correlation-id") String correlationId,
            @PathVariable("customerId") Long customerId) {
        log.debug("Correlation Id found: {}", correlationId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanService.findByCustomerId(customerId));
    }
}

