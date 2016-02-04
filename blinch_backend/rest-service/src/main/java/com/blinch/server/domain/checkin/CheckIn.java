package com.blinch.server.domain.checkin;

import com.blinch.common.domain.AbstractAuditableEntity;
import com.blinch.server.domain.customer.User;
import com.blinch.server.domain.event.Event;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by markuskopf on 02/02/16.
 */

@Document(language = "CheckIn")
public class CheckIn extends AbstractAuditableEntity {

    @DBRef
    private User user;

    @DBRef
    @NotEmpty
    private Event event;

    @NotEmpty
    private Date checkinDate;


    public CheckIn(User user, Event event, Date checkinDate) {
        this.user = user;
        this.event = event;
        this.checkinDate = checkinDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }
}
