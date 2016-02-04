package com.blinch.server.domain.event;

import com.blinch.common.domain.AbstractAuditableEntity;
import com.blinch.server.domain.group.BLIGroup;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by markuskopf on 29/01/16.
 */
public class Event extends AbstractAuditableEntity {

    @DBRef
    private BLIGroup group;

    @NotEmpty
    private Date eventDate;

    private long weekday;

    private long longitute;

    private long latitude;

    private String location;

    public Event() {

    }

    public Event(BLIGroup group, Date date, long longitute, long latitude, String location, long weekday) {
        this.group = group;
        this.eventDate = date;
        this.longitute = longitute;
        this.latitude = latitude;
        this.location = location;
        this.weekday = weekday;
    }

    public long getWeekday() {
        return weekday;
    }

    public void setWeekday(long weekday) {
        this.weekday = weekday;
    }

    public BLIGroup getGroup() {
        return group;
    }

    public void setGroup(BLIGroup group) {
        this.group = group;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public long getLongitute() {
        return longitute;
    }

    public void setLongitute(long longitute) {
        this.longitute = longitute;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
