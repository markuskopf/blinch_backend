package com.blinch.server.service.event;

import com.blinch.server.domain.event.EventDTO;
import com.blinch.server.domain.group.BLIGroup;

import java.util.HashSet;
import java.util.Optional;

/**
 * Created by markuskopf on 29/01/16.
 */

public interface EventService {

    EventDTO create(EventDTO event);

    void delete(String id);

    EventDTO findEventByGroupName(BLIGroup group);

}
