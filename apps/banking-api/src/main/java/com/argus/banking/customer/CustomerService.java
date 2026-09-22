package com.argus.banking.customer;

import org.springframework.stereotype.Service;

import com.argus.banking.customer.dto.CreateCustomerRequest;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CreateCustomerRequest request) {

        if (customerRepository.existsByCustomerNumber(request.customerNumber())) {
            throw new IllegalArgumentException("Customer number already exists");
        }

        if (customerRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email already exists");
        }

        Customer customer = new Customer(
                request.customerNumber(),
                request.firstName(),
                request.lastName(),
                request.email(),
                "ACTIVE"
        );

        return customerRepository.save(customer);
    }
}