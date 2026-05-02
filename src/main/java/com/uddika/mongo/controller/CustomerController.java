package com.uddika.mongo.controller;


import com.uddika.mongo.model.dto.CustomerRequest;
import com.uddika.mongo.model.dto.CustomerResponse;
import com.uddika.mongo.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // POST /api/customers — Register new customer
    @PostMapping
    public ResponseEntity<CustomerResponse> register(@Valid @RequestBody CustomerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.register(request));
    }

    // GET /api/customers — Get all customers
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    // GET /api/customers/{id} — Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    // PUT /api/customers/{id} — Update customer
    @Operation(summary = "Update customer")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(
            @PathVariable String id,
            @Valid @RequestBody CustomerRequest request) {
        return ResponseEntity.ok(customerService.update(id, request));
    }

    // DELETE /api/customers/{id} — Delete customer
    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Customer deleted")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/customers/search?q=john — Search by name
    @GetMapping("/search")
    public ResponseEntity<List<CustomerResponse>> search(@RequestParam String q) {
        return ResponseEntity.ok(customerService.search(q));
    }
}
