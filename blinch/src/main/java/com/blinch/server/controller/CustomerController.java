package com.blinch.server.controller;

import com.blinch.server.domain.CustomerDTO;
import com.blinch.server.domain.StatusResponse;
import com.blinch.server.exeption.UserNotFoundException;
import com.blinch.server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by markuskopf on 18/01/16.
 */
@RestController
public class CustomerController {

    private final AccountService service;

    @Autowired
    CustomerController(AccountService service) {
        this.service = service;
    }

    @RequestMapping(value = "/api/v1/status2")
    public StatusResponse status() {
        final StatusResponse response = new StatusResponse();
        response.setMessage("CustomerController service is running...)");
        response.setStatus(200);

        return response;
    }

    @RequestMapping(value = "/api/v1/customer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    CustomerDTO create(@RequestBody @Valid CustomerDTO customerEntry) {
        return service.create(customerEntry);
    }

    @RequestMapping(value = "/api/v1/customer/{id}", method = RequestMethod.DELETE)
    CustomerDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/v1/customer/{lastName}", method = RequestMethod.GET)
    CustomerDTO findByLastName(@PathVariable("lastName") String lastName) {
        return service.findByLastName(lastName);
    }

    @RequestMapping(value = "/api/v1/customer/{id}", method = RequestMethod.GET)
    CustomerDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(UserNotFoundException ex) {
    }

}
