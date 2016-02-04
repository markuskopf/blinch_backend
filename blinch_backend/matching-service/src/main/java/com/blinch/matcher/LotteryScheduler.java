package com.blinch.matcher;

import com.blinch.server.domain.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by markuskopf on 03/02/16.
 */

@Component
public class LotteryScheduler {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    final EventRepository eventRepository;

    @Autowired
    public LotteryScheduler(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Scheduled(fixedRate = 50000)
    //@Scheduled(cron = "0/5 * * * * ?")
    public void reportCurrentTime() {
        // TODO: Check which users are checked-in and match respectively two and inform.

        System.out.println("LotteryScheduler component: " + dateFormat.format(new Date()));

        // TODO:
        // 1.) Check every day at 11 which groups has an event scheduled.
        // 2.) Take those groups and check all checked-in users of this group
        // 3.) Match them in a random way.
            // 3. a) Consider the history of appointments
        // 4.) Push them the information
        // 5.) Save them in an appointment --> this is the history
        // 6.) Delete checked-in users so start from scratch next time

    }


}
