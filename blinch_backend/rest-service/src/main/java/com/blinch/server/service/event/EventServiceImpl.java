package com.blinch.server.service.event;

import com.blinch.server.domain.event.Event;
import com.blinch.server.domain.event.EventDTO;
import com.blinch.server.domain.event.EventRepository;
import com.blinch.server.domain.group.BLIGroup;
import com.blinch.server.domain.group.BLIGroupRepository;
import com.blinch.server.exception.EventNotFoundException;
import com.blinch.server.exception.GroupNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

/**
 * Created by markuskopf on 29/01/16.
 */

@Service
public class EventServiceImpl implements  EventService {

    final BLIGroupRepository bliGroupRepository;
    final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(BLIGroupRepository bliGroupRepository, EventRepository eventRepository) {
        this.bliGroupRepository = bliGroupRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDTO create(EventDTO event) {
        BLIGroup groupForEvent = this.findGroupByGroupName(event.getGroupName());

        Event persisted = new Event(groupForEvent, event.getDate(), event.getLongitute(), event.getLatitude(), event.getLocation());
        persisted = this.eventRepository.save(persisted);

        return convertToDTO(persisted);
    }

    @Override
    public void delete(String id) {
        // Not implemented yet
    }

    @Override
    public EventDTO findEventByGroupName(BLIGroup group) {
        Event persistedEvent = findEventWithGroup(group);
        return convertToDTO(persistedEvent);
    }


    private Event findEventWithGroup(BLIGroup group) {
        Optional<Event> result = eventRepository.findEventByGroup(group);
        return result.orElseThrow( () -> new EventNotFoundException(group.getGroupName()));
    }

    private BLIGroup findGroupByGroupName(String groupName) {
        Optional<BLIGroup> result = bliGroupRepository.findByGroupName(groupName);
        return result.orElseThrow( () -> new GroupNotFoundException(groupName));
    }

    private EventDTO convertToDTO(Event event) {
        EventDTO eventDTO =  new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setGroupName(event.getGroup().getGroupName());
        eventDTO.setDate(event.getDate());
        eventDTO.setLatitude(event.getLatitude());
        eventDTO.setLongitute(event.getLongitute());
        eventDTO.setLocation(event.getLocation());

        return eventDTO;
    }

}
