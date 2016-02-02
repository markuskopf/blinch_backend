package com.blinch.server.web;

import com.blinch.server.domain.event.EventDTO;
import com.blinch.server.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by markuskopf on 29/01/16.
 */

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    final EventService service;

    @Autowired
    public EventController(EventService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    EventDTO create(@RequestBody @Valid EventDTO eventEntry) {
        return service.create(eventEntry);
    }


}
