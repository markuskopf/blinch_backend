package com.blinch.server.domain.customer;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

/**
 * Created by markuskopf on 18/01/16.
 */
public class Customer {

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

    @Size(min = 5, max = 20)
    private String password;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
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
}
