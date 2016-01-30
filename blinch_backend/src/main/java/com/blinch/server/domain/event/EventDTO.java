package com.blinch.server.domain.event;

import com.blinch.server.domain.group.BLIGroup;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by markuskopf on 29/01/16.
 */
public class EventDTO {

    private String id;

    @NotEmpty
    private BLIGroup group;

    @NotEmpty
    private Date date;

    private long longitute;

    private long latitude;

    @NotEmpty
    @Size(min = 1)
    private String location;


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
