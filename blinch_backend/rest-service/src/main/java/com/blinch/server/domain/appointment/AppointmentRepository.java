package com.blinch.server.domain.appointment;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by markuskopf on 28/01/16.
 */

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    Optional<Appointment> findById(String id);

    Appointment save(Appointment saved);

}
