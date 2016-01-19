package com.blinch.server.domain;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * Created by markuskopf on 18/01/16.
 */
public class CustomerDTO {

    private String id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
