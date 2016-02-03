package com.blinch.server.domain.checkin;

import com.blinch.server.domain.customer.User;
import com.blinch.server.domain.event.Event;

import java.util.Date;

/**
 * Created by markuskopf on 02/02/16.
 */
public class CheckInDTO {

    private Event event;

    private User user;

    private Date checkinDate;

    private String id;


    public CheckInDTO(Event event, User user, Date checkinDate) {
        this.event = event;
        this.user = user;
        this.checkinDate = checkinDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
