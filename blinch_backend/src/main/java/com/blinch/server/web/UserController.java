package com.blinch.server.web;

import com.blinch.server.domain.customer.UserDTO;
import com.blinch.server.exception.UserNotFoundException;
import com.blinch.server.service.account.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by markuskopf on 18/01/16.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO create(@RequestBody @Valid UserDTO customerEntry) {
        return service.create(customerEntry);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    UserDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/{lastName}", method = RequestMethod.GET)
    UserDTO findByLastName(@PathVariable("lastName") String lastName) {
        return service.findByLastName(lastName);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    UserDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(UserNotFoundException ex) {

        LOGGER.info("User not found exception...", ex);

    }

}
