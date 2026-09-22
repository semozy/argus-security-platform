package com.argus.banking.customer.dto;

public record CreateCustomerRequest(
        String customerNumber,
        String firstName,
        String lastName,
        String email
) {
}