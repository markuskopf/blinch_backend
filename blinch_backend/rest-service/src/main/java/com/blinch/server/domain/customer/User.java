package com.blinch.server.domain.customer;

import com.blinch.server.domain.appointment.Appointment;
import com.blinch.server.domain.group.BLIGroup;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.Size;
import java.util.HashSet;

/**
 * Created by markuskopf on 18/01/16.
 */
public class User {

    @Id
    private String id;

    @Size(min = 2, max = 1000)
    private String firstName;

    @Size(min = 2, max = 1000)
    private String lastName;

    @Size(min = 2, max = 1000)
    private String emailAddress;

    private String phone;

    private String company;

    private String street;

    private String city;

    private String country;

    @DBRef
    private BLIGroup bliGroup;

    @DBRef
    private HashSet<Appointment> appointments;

    @Size(min = 5, max = 20)
    private String password;

    public User() {}

    public User(String firstName, String lastName, String emailAddress, String phone, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.company = company;
    }

    public void setBliGroup(BLIGroup blichGroup) throws IllegalArgumentException {
        if (blichGroup != null) {
            this.bliGroup = blichGroup;
        } else {
            throw new IllegalArgumentException("Group must not be null.");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashSet<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(HashSet<Appointment> appointments) {
        this.appointments = appointments;
    }

    public BLIGroup getBliGroup() {
        return bliGroup;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
