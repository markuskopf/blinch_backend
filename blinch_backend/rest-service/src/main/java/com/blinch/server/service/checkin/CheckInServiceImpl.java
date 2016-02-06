package com.blinch.server.service.checkin;

import com.blinch.server.domain.checkin.CheckIn;
import com.blinch.server.domain.checkin.CheckInDTO;
import com.blinch.server.domain.checkin.CheckInRepository;
import com.blinch.server.domain.customer.User;
import com.blinch.server.domain.customer.UserDTO;
import com.blinch.server.domain.customer.UserRepository;
import com.blinch.server.domain.event.Event;
import com.blinch.server.domain.event.EventRepository;
import com.blinch.server.domain.group.BLIGroup;
import com.blinch.server.service.account.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by markuskopf on 02/02/16.
 */
@Service
public class CheckInServiceImpl implements CheckInService {

    final CheckInRepository checkInRepository;

    final UserRepository userRepository;

    final EventRepository eventRepository;

    @Autowired
    public CheckInServiceImpl(CheckInRepository checkInRepository, UserRepository userRepository, EventRepository eventRepository) {
        this.checkInRepository = checkInRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public CheckInDTO create(CheckInDTO checkIn) {

        // TODO: Check users group and for the group the event
        // if event is there and checkin on the same day allow checkin


        Optional<User> user = this.userRepository.findByEmailAddress(checkIn.getEmailAddress());
        User currentUser  = user.get();

        BLIGroup group = currentUser.getBliGroup();

        // search Event for group
        Optional<Event> event = this.eventRepository.findEventByGroup(group);

        // TODO: Check if everything is ok and save. If not throw an exception.


        CheckIn persited = new CheckIn(currentUser, event.get(), checkIn.getCheckinDate());
        persited = this.checkInRepository.save(persited);

        return convertToDTO(persited);
    }

    @Override
    public List<CheckIn> findAllCheckIns() {
        List<CheckIn>checkIns = this.checkInRepository.findAll();

        return checkIns;
    }

    private CheckInDTO convertToDTO(CheckIn checkin) {
        CheckInDTO dto = new CheckInDTO(checkin.getEvent(), checkin.getUser(), checkin.getCheckinDate(), checkin.getUser().getId()
        , checkin.getUser().getEmailAddress());

        dto.setId(checkin.getId());

        return dto;
    }
}
