package com.blinch.server.domain.checkin;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by markuskopf on 02/02/16.
 */
public interface CheckInRepository extends MongoRepository<CheckIn, String>{

    CheckIn save(CheckIn saved);

}
