package com.blinch.server.service;

import com.blinch.server.domain.Customer;
import com.blinch.server.domain.CustomerDTO;
import com.blinch.server.domain.CustomerRepository;;
import com.blinch.server.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by markuskopf on 18/01/16.
 */
@Service
final class MongoDBAccountService implements AccountService{

    private final CustomerRepository repository;

    @Autowired
    MongoDBAccountService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerDTO create(CustomerDTO customer) {
        Customer persisted = new Customer(customer.getFirstName(), customer.getLastName());
        persisted = repository.save(persisted);

        return convertToDTO(persisted);
    }

    @Override
    public CustomerDTO delete(String id) {
        Customer deleted = findCustomerById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }


    @Override
    public CustomerDTO findByLastName(String lastName) {
       Customer findByLastNameCustomer = findCustomerByLastName(lastName);

        return convertToDTO(findByLastNameCustomer);
    }

    @Override
    public CustomerDTO findByFirstName(String firstName) {
        Customer findByFirstNameCustomer = findCustomerByFirstName(firstName);

        return convertToDTO(findByFirstNameCustomer);
    }

    @Override
    public CustomerDTO findById(String id) {
        return convertToDTO(findCustomerById(id));
    }

    private Customer findCustomerByLastName(String lastName) {
        Optional<Customer> result = repository.findByLastName(lastName);
        return result.orElseThrow(() -> new UserNotFoundException(lastName));
    }

    private Customer findCustomerByFirstName(String firstName) {
        Optional<Customer> result = repository.findByFirstName(firstName);
        return result.orElseThrow(() -> new UserNotFoundException(firstName));
    }

    private Customer findCustomerById(String id) {
        Optional<Customer> result = repository.findOne(id);
        return result.orElseThrow(() -> new UserNotFoundException(id));
    }

    private CustomerDTO convertToDTO(Customer model) {
        CustomerDTO dto = new CustomerDTO();

        dto.setId(model.getId());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());

        return dto;
    }

}
