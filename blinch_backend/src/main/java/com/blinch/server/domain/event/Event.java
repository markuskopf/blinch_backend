package com.blinch.server.domain.event;

import com.blinch.server.domain.group.BLIGroup;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by markuskopf on 29/01/16.
 */
public class Event {

    @Id
    private String id;

    @DBRef
    private BLIGroup group;

    private Date date;

    private long longitute;

    private long latitude;

    private String location;

    public Event() {

    }

    public Event(String id, BLIGroup group, Date date, long longitute, long latitude, String location) {
        this.id = id;
        this.group = group;
        this.date = date;
        this.longitute = longitute;
        this.latitude = latitude;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BLIGroup getGroup() {
        return group;
    }

    public void setGroup(BLIGroup group) {
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
