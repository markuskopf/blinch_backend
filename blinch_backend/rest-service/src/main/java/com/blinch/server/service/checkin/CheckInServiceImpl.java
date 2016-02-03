package com.blinch.server.service.checkin;

import com.blinch.server.domain.checkin.CheckIn;
import com.blinch.server.domain.checkin.CheckInDTO;
import com.blinch.server.domain.checkin.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by markuskopf on 02/02/16.
 */
@Service
public class CheckInServiceImpl implements CheckInService {

    final CheckInRepository checkInRepository;

    @Autowired
    public CheckInServiceImpl(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }

    @Override
    public CheckInDTO create(CheckInDTO checkIn) {

        // TODO: Check users group and for the group the event
        // if event is there and checkin on the same day allow checkin

        CheckIn persited = new CheckIn(checkIn.getUser(),checkIn.getEvent(), checkIn.getCheckinDate());
        persited = this.checkInRepository.save(persited);

        return convertToDTO(persited);
    }

    private CheckInDTO convertToDTO(CheckIn checkin) {
        CheckInDTO dto = new CheckInDTO(checkin.getEvent(), checkin.getUser(), checkin.getCheckinDate());
        dto.setId(checkin.getId());

        return dto;
    }
}
