package com.blinch.server.web;

import com.blinch.server.domain.group.BLIGroupDTO;
import com.blinch.server.exception.UserNotFoundException;
import com.blinch.server.service.group.BLIGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by markuskopf on 26/01/16.
 */

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    private final BLIGroupService service;

    @Autowired
    public GroupController(BLIGroupService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public BLIGroupDTO create(@RequestBody @Valid BLIGroupDTO groupEntry) {
        BLIGroupDTO createdGroup = service.create(groupEntry);
        return createdGroup;
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public BLIGroupDTO findById(@PathVariable("id") String id) {
//        return service.findById(id);
//    }

    @RequestMapping(value = "/name/{groupName}", method = RequestMethod.GET)
    public BLIGroupDTO findByGroupName(@PathVariable("groupName") String groupName) {
        return  service.findByGroupName(groupName);
    }

    @RequestMapping(value = "/{domainName}", method = RequestMethod.GET)
    public BLIGroupDTO findByDomainName(@PathVariable("domainName") String domainName) {
        return service.findByDomainName(domainName);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(UserNotFoundException ex) {

    }

}
