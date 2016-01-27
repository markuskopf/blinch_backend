package com.blinch.server.domain.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by markuskopf on 18/01/16.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByFirstName(String firstName);

    Optional<Customer> findByLastName(String lastName);

//    Optional<Customer> findOne(String id);

    void delete(Customer deleted);

    Customer save(Customer saved);

}