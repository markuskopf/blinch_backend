package com.blinch.server.domain.appointment;

import com.blinch.server.domain.customer.Customer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.HashSet;

/**
 * Created by markuskopf on 28/01/16.
 */
public class Appointment {

    @Id
    private String id;

    @DBRef
    private HashSet<Customer> customers;

    private Date appointmentDate;

    private String locationName;

    private long longitute;

    private long latitude;

    private String city;

    public Appointment() {

    }

    public Appointment(HashSet<Customer> customers, Date appointmentDate, String locationName, long longitute, long latitude, String city) {
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

    public HashSet<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(HashSet<Customer> customers) {
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
