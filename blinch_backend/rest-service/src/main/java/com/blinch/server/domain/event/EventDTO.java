package com.blinch.server.domain.event;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by markuskopf on 29/01/16.
 */
public class EventDTO {

    private String id;

    @NotEmpty
    private String groupName;

    private Date eventDate;

    private long longitute;

    private long latitude;

    private long weekday;

    @NotEmpty
    @Size(min = 1)
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public long getWeekday() {
        return weekday;
    }

    public void setWeekday(long weekday) {
        this.weekday = weekday;
    }
}
