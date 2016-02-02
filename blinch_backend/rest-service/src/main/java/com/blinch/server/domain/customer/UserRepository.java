package com.blinch.server.domain.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by markuskopf on 18/01/16.
 */
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByFirstName(String firstName);

    Optional<User> findByLastName(String lastName);

//    Optional<User> findOne(String id);

    void delete(User deleted);

    User save(User saved);

}