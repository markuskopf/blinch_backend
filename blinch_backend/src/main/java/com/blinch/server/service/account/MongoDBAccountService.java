package com.blinch.server.service.account;

import com.blinch.server.domain.customer.Customer;
import com.blinch.server.domain.customer.CustomerDTO;
import com.blinch.server.domain.customer.CustomerRepository;;
import com.blinch.server.domain.group.BLIGroup;
import com.blinch.server.domain.group.BLIGroupRepository;
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

    private final BLIGroupRepository groupRepository;

    @Autowired
    public MongoDBAccountService(CustomerRepository repository, BLIGroupRepository groupRepository) {
        this.repository = repository;
        this.groupRepository = groupRepository;
    }

    @Override
    public CustomerDTO create(CustomerDTO customer) {

        String emailOfCustomer = customer.getEmailAddress();
        String domain =  emailOfCustomer.substring((emailOfCustomer.lastIndexOf("@") + 1));

        // search by domain of the email inside mongo
        // if domain found create the customer with a link to the company
        // if not return error

        Optional<BLIGroup> groupOfCustomer = this.groupRepository.findByDomainName(domain);

        BLIGroup group = groupOfCustomer.get();
        if (group == null) {
            // throw information that first a valid group must be created....

            return null;
        }

        Customer persisted = new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmailAddress(), customer.getPhone(), customer.getCompany());
        persisted.setBliGroup(group);


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
        Optional<Customer> result = null; // repository.findOne(id);
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
