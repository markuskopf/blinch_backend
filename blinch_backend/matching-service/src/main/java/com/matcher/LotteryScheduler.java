package com.matcher;

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

    @Scheduled(fixedRate = 5000)
    //@Scheduled(cron = "0/5 * * * * ?")
    public void reportCurrentTime() {
        // TODO: Check which users are checked-in and match respectively two and inform.

        System.out.println("LotteryScheduler component: " + dateFormat.format(new Date()));
    }


}
