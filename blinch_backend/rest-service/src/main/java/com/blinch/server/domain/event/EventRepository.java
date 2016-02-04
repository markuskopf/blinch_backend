package com.blinch.server.domain.event;

import com.blinch.server.domain.group.BLIGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.HashSet;
import java.util.Optional;

/**
 * Created by markuskopf on 29/01/16.
 */
public interface EventRepository extends MongoRepository<Event, String> {


    Event save(Event saved);

//    Optional<HashSet<Event>> getAllEvents();

    Optional<Event> findEventByGroup(BLIGroup group);



}
