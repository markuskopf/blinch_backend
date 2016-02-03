package com.blinch.server.web;

import com.blinch.server.domain.checkin.CheckInDTO;
import com.blinch.server.service.checkin.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by markuskopf on 02/02/16.
 */

@RestController
public class CheckInController {

    final CheckInService service;

    @Autowired
    public CheckInController(CheckInService service) {
        this.service = service;
    }

    @RequestMapping(value = "/api/v1/checkins", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    CheckInDTO create(@RequestBody @Valid CheckInDTO checkInEntry) {
        return service.create(checkInEntry);
    }


}
