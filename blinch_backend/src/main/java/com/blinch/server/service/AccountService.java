package com.blinch.server.service;

import com.blinch.server.domain.CustomerDTO;

/**
 * Created by markuskopf on 18/01/16.
 */
public interface AccountService {

    CustomerDTO create(CustomerDTO customer);

    CustomerDTO delete(String id);

    CustomerDTO findByLastName(String lastName);

    CustomerDTO findByFirstName(String firstName);

    CustomerDTO findById(String id);


}
