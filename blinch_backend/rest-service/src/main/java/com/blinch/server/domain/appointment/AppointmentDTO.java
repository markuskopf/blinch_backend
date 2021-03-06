package com.blinch.server.domain.appointment;

import com.blinch.server.domain.customer.User;

import java.util.Date;
import java.util.HashSet;

/**
 * Created by markuskopf on 28/01/16.
 */
public class AppointmentDTO {

    private String id;

    private HashSet<User> customers;

    private Date appointmentDate;

    private String locationName;

    private long longitute;

    private long latitude;

    private String city;

    public AppointmentDTO() {

    }

    public AppointmentDTO(String id, HashSet<User> customers, Date appointmentDate, String locationName, long longitute, long latitude, String city) {
        this.id = id;
        this.customers = customers;
        this.appointmentDate = appointmentDate;
        this.locationName = locationName;
        this.longitute = longitute;
        this.latitude = latitude;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashSet<User> getCustomers() {
        return customers;
    }

    public void setCustomers(HashSet<User> customers) {
        this.customers = customers;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
