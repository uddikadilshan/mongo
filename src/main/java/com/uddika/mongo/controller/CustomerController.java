package com.uddika.mongo.controller;


import com.uddika.mongo.model.dto.CustomerRequest;
import com.uddika.mongo.model.dto.CustomerResponse;
import com.uddika.mongo.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Tag(name = "Customer", description = "Customer management API")
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Register a new customer")
    @PostMapping
    public ResponseEntity<CustomerResponse> register(@Valid @RequestBody CustomerRequest request) {
        log.info("Request to register customer with email: {}", request.email());
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.register(request));
    }

    @Operation(summary = "Get all customers")
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll() {
        log.info("Request to fetch all customers");
        return ResponseEntity.ok(customerService.getAll());
    }

    @Operation(summary = "Get customer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable String id) {
        log.info("Request to fetch customer with id: {}", id);
        return ResponseEntity.ok(customerService.getById(id));
    }

    @Operation(summary = "Update customer")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(
            @PathVariable String id,
            @Valid @RequestBody CustomerRequest request) {
        log.info("Request to update customer with id: {}", id);
        return ResponseEntity.ok(customerService.update(id, request));
    }

    @Operation(summary = "Delete customer — ADMIN only")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Request to delete customer with id: {}", id);
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search customers by name")
    @GetMapping("/search")
    public ResponseEntity<List<CustomerResponse>> search(@RequestParam String q) {
        log.info("Request to search customers with query: {}", q);
        return ResponseEntity.ok(customerService.search(q));
    }
}

