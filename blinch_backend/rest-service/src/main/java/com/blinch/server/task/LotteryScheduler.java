package com.blinch.server.task;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.blinch.server.domain.checkin.CheckIn;
import com.blinch.server.domain.event.Event;
import com.blinch.server.domain.event.EventRepository;
import com.blinch.server.service.checkin.CheckInService;
import com.blinch.server.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
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

    @Scheduled(cron="0 0 11 * * *")
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

        try {
            // Find device_token of user
            //        String deviceToken = "e8fabbe944e2764dd344e7ab1838b847da0b1a3ca1104eab23378480ff08e91c"; PushDemo Tanja
//            String deviceToken = "a17890bc9a50586788faa37e75c69a595779b6e073f2e297423bbf6273065f07"; // This is 64 hex characters. PushDemo Markus
            String deviceToken = "70cddd4230a0c0cec198ffa6dbded56130a247f14656ff8212ecdb4ee106324b"; // BlinchApp Token Markus

            this.triggerPushNotificationForMatchPartner(deviceToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void triggerPushNotificationForMatchPartner(String deviceToken) throws IOException {
        InputStream resource = LotteryScheduler.class.getResourceAsStream("/AwsCredentials.properties");
        AmazonSNS sns = new AmazonSNSClient(new PropertiesCredentials(resource));

        sns.setEndpoint("https://sns.us-west-2.amazonaws.com");

        try {
            MobilePush mobilePush = new MobilePush(sns);
            mobilePush.appleSandboxAppNotification(deviceToken);
        } catch (AmazonServiceException ase) {
            System.out
                    .println("Caught an AmazonServiceException, which means your request made it "
                            + "to Amazon SNS, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out
                    .println("Caught an AmazonClientException, which means the client encountered "
                            + "a serious internal problem while trying to communicate with SNS, such as not "
                            + "being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }

    }
}
