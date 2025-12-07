package com.serey.bank.account.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Version
    private Long version;

    private String name;
    private String email;
    private String mobileNumber;
    private LocalDate createDate;
}
