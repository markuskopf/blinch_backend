package com.blinch.server.service.account;

import com.blinch.server.domain.customer.User;
import com.blinch.server.domain.customer.UserDTO;
import com.blinch.server.domain.customer.UserRepository;;
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
final class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final BLIGroupRepository groupRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository, BLIGroupRepository groupRepository) {
        this.repository = repository;
        this.groupRepository = groupRepository;
    }

    @Override
    public UserDTO create(UserDTO customer) {

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

        User persisted = new User(customer.getFirstName(), customer.getLastName(), customer.getEmailAddress(), customer.getPhone(), customer.getCompany());
        persisted.setBliGroup(group);


        persisted = repository.save(persisted);

        return convertToDTO(persisted);
    }

    @Override
    public UserDTO delete(String id) {
        User deleted = findCustomerById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }


    @Override
    public UserDTO findByLastName(String lastName) {
       User findByLastNameCustomer = findCustomerByLastName(lastName);

        return convertToDTO(findByLastNameCustomer);
    }

    @Override
    public UserDTO findByFirstName(String firstName) {
        User findByFirstNameCustomer = findCustomerByFirstName(firstName);

        return convertToDTO(findByFirstNameCustomer);
    }

    @Override
    public UserDTO findById(String id) {
        return convertToDTO(findCustomerById(id));
    }

    @Override
    public UserDTO findByEmailAddress(String emailAddress) {
        return convertToDTO(findUserByEmailAddress(emailAddress));
    }

    private User findUserByEmailAddress(String emailAddress) {
        Optional<User> result = repository.findByEmailAddress(emailAddress);
        return result.orElseThrow(() -> new UserNotFoundException(emailAddress));
    }

    private User findCustomerByLastName(String lastName) {
        Optional<User> result = repository.findByLastName(lastName);
        return result.orElseThrow(() -> new UserNotFoundException(lastName));
    }

    private User findCustomerByFirstName(String firstName) {
        Optional<User> result = repository.findByFirstName(firstName);
        return result.orElseThrow(() -> new UserNotFoundException(firstName));
    }

    private User findCustomerById(String id) {
        Optional<User> result = null; // repository.findOne(id);
        return result.orElseThrow(() -> new UserNotFoundException(id));
    }

    private UserDTO convertToDTO(User model) {
        UserDTO dto = new UserDTO();

        dto.setId(model.getId());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setEmailAddress(model.getEmailAddress());

        return dto;
    }

}
