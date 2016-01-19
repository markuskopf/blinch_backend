package com.blinch.server.domain;

import com.blinch.server.domain.Customer;
import org.springframework.data.repository.Repository;
import java.util.Optional;

/**
 * Created by markuskopf on 18/01/16.
 */
public interface CustomerRepository extends Repository<Customer, String> {


    Optional<Customer> findByFirstName(String firstName);

    Optional<Customer> findByLastName(String lastName);

    Optional<Customer> findOne(String id);

    void delete(Customer deleted);

    Customer save(Customer saved);

}