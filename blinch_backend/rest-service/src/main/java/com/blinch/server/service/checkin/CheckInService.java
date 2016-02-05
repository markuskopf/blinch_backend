package com.blinch.server.service.checkin;

import com.blinch.server.domain.checkin.CheckInDTO;

/**
 * Created by markuskopf on 02/02/16.
 */
public interface CheckInService {

    CheckInDTO create(CheckInDTO checkIn);

    // TODO: give users who checked-in for a company

}
