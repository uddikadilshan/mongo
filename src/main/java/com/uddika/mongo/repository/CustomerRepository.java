package com.uddika.mongo.repository;

import com.uddika.mongo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Customer> findByActive(boolean active);

    List<Customer> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName, String lastName
    );
}
