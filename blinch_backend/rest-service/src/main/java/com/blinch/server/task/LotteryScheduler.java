package com.blinch.server.task;

import com.blinch.server.domain.checkin.CheckIn;
import com.blinch.server.domain.event.Event;
import com.blinch.server.domain.event.EventRepository;
import com.blinch.server.service.checkin.CheckInService;
import com.blinch.server.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by markuskopf on 03/02/16.
 */

@Component
public class LotteryScheduler {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    final EventService eventService;

    final CheckInService checkInService;

    @Autowired
    public LotteryScheduler(EventService eventService, CheckInService checkInService) {
        this.eventService = eventService;
        this.checkInService = checkInService;
    }

    @Scheduled(fixedRate = 5000)
    //@Scheduled(cron = "0/5 * * * * ?")
    public void reportCurrentTime() {
        // TODO: Check which users are checked-in and match respectively two and inform.

        // TODO:
        // 1.) Check every day at 11 which groups has an event scheduled.
        // 2.) Take those groups and check all checked-in users of this group
        // 3.) Match them in a random way.
            // 3. a) Consider the history of appointments
        // 4.) Push them the information
        // 5.) Save them in an appointment --> this is the history
        // 6.) Delete checked-in users so start from scratch next time

        List<Event> events = this.eventService.findAllEvents();
        // check every event if the weekday is the current weekday

        List<CheckIn> checkIns = this.checkInService.findAllCheckIns();

        List<CheckIn> firstPortion = new ArrayList<>();
        List<CheckIn> lastPortion = new ArrayList<>();

        int median = checkIns.size() / 2;

        if (median == 0) {
            return;
        }

        for (int i=0; i<checkIns.size(); i++) {
            if (i < median) {
                firstPortion.add(checkIns.get(i));
            } else {
                lastPortion.add(checkIns.get(i));
            }
        }

        for (int i=0; i<lastPortion.size(); i++) {
            System.out.println("Lunchpartners are: " + firstPortion.get(i).getUser().getFirstName() + " with " + lastPortion.get(i).getUser().getFirstName());
        }

//        System.out.println("LotteryScheduler component: " + dateFormat.format(new Date()));

    }


}
