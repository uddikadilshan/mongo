package com.uddika.mongo.model.dto;


import com.uddika.mongo.model.Customer;

import java.time.LocalDateTime;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    // Static factory method to map from entity
    public static CustomerResponse from(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress(),
                customer.isActive(),
                customer.getCreatedAt(),
                customer.getUpdatedAt()
        );
    }
}
