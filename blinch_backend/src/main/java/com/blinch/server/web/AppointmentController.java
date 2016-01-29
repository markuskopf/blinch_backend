package com.blinch.server.web;

/**
 * Created by markuskopf on 28/01/16.
 */

import com.blinch.server.domain.appointment.AppointmentDTO;
import com.blinch.server.service.appointment.AppountmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    final AppountmentService service;

    @Autowired
    public AppointmentController(AppountmentService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    AppointmentDTO create(@RequestBody @Valid AppointmentDTO appointmentEntry) {
        return service.create(appointmentEntry);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    AppointmentDTO delete(@RequestParam(value = "id") String id) {
        return service.delete(id);
    }

}
