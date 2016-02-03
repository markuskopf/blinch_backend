package com.blinch.server.matching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by markuskopf on 02/02/16.
 */


@Component
public class ScheduledLottery {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    private final UserRepository customerRepository;

//    @Autowired
//    public com.blinch.server.matching.ScheduledLottery(UserRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    @Scheduled(fixedRate = 5000)
    //@Scheduled(cron = "0/5 * * * * ?")
    public void reportCurrentTime() {
        // TODO: Check which users are checked-in and match respectively two and inform.

        System.out.println("Blind lunch date: " + dateFormat.format(new Date()));
    }

}
