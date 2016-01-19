package com.blinch.server.controller;

import com.blinch.server.domain.CustomerDTO;
import com.blinch.server.exeption.UserNotFoundException;
import com.blinch.server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Created by markuskopf on 18/01/16.
 */
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final AccountService service;

    @Autowired
    CustomerController(AccountService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    CustomerDTO create(@RequestBody @Valid CustomerDTO customerEntry) {
        return service.create(customerEntry);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    CustomerDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/{lastName}", method = RequestMethod.GET)
    CustomerDTO findByLastName(@PathVariable("lastName") String lastName) {
        return service.findByLastName(lastName);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    CustomerDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(UserNotFoundException ex) {
    }

}
