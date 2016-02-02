package com.blinch.server.domain.event;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by markuskopf on 29/01/16.
 */
public interface EventRepository extends MongoRepository<Event, String> {

//    Optional<Event> findById(String id);

    Event save(Event saved);

//    Optional<HashSet<Event>> getAllEvents();

//    Optional<Event> findByLocation(String location);

}
