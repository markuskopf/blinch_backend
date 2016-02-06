package com.blinch.server.service.checkin;

import com.blinch.server.domain.checkin.CheckIn;
import com.blinch.server.domain.checkin.CheckInDTO;

import java.util.List;

/**
 * Created by markuskopf on 02/02/16.
 */
public interface CheckInService {

    CheckInDTO create(CheckInDTO checkIn);

    List<CheckIn> findAllCheckIns();

}
