package com.blinch.server.service.account;

import com.blinch.server.domain.customer.UserDTO;

/**
 * Created by markuskopf on 18/01/16.
 */
public interface UserService {

    UserDTO create(UserDTO customer);

    UserDTO delete(String id);

    UserDTO findByLastName(String lastName);

    UserDTO findByFirstName(String firstName);

    UserDTO findById(String id);


}
