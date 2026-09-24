package com.argus.banking.account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);

    Optional<Account> findByIban(String iban);

    boolean existsByAccountNumber(String accountNumber);

    boolean existsByIban(String iban);

    List<Account> findByCustomerId(Long customerId);
}