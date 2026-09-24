package com.argus.banking.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateCustomerRequest(

        @NotBlank(message = "Customer number is required")
        @Pattern(
                regexp = "^CUST-[0-9]{6}$",
                message = "Customer number must follow the format CUST-000001"
        )
        String customerNumber,

        @NotBlank(message = "First name is required")
        @Size(
                max = 100,
                message = "First name cannot exceed 100 characters"
        )
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(
                max = 100,
                message = "Last name cannot exceed 100 characters"
        )
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        @Size(
                max = 255,
                message = "Email cannot exceed 255 characters"
        )
        String email

) {
}