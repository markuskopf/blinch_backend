package com.blinch.server.service;

import com.blinch.server.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by markuskopf on 28/01/16.
 */

@Component
public class ScheduledLottery {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final CustomerRepository customerRepository;

    @Autowired
    public ScheduledLottery(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        // TODO: Check which users are checked-in and match respectively two and inform.

        System.out.println("Blind lunch date: " + dateFormat.format(new Date()));
    }

}
