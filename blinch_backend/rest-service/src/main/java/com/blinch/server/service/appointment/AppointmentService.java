package com.blinch.server.service.appointment;


import com.blinch.server.domain.appointment.AppointmentDTO;


/**
 * Created by markuskopf on 28/01/16.
 */
public interface AppointmentService {

    AppointmentDTO create(AppointmentDTO appointment);

    AppointmentDTO delete(String id);

}
