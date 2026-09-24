package com.argus.banking.account;

import java.math.BigDecimal;
import java.time.Instant;

import com.argus.banking.customer.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "account_number",
            nullable = false,
            unique = true,
            updatable = false
    )
    private String accountNumber;

    @Column(
            nullable = false,
            unique = true,
            updatable = false
    )
    private String iban;

    @Column(
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal balance;

    @Column(
            nullable = false,
            length = 3
    )
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "customer_id",
            nullable = false
    )
    private Customer customer;

    @Column(
            name = "created_at",
            nullable = false,
            updatable = false
    )
    private Instant createdAt;

    protected Account() {
        // Required by JPA
    }

    public Account(
            String accountNumber,
            String iban,
            BigDecimal balance,
            String currency,
            AccountStatus status,
            AccountType accountType,
            Customer customer
    ) {
        this.accountNumber = accountNumber;
        this.iban = iban;
        this.balance = balance;
        this.currency = currency;
        this.status = status;
        this.accountType = accountType;
        this.customer = customer;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}