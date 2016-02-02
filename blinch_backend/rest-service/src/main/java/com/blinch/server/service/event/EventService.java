package com.blinch.server.service.event;

import com.blinch.server.domain.event.EventDTO;

/**
 * Created by markuskopf on 29/01/16.
 */

public interface EventService {

    EventDTO create(EventDTO event);

    void delete(String id);

}
