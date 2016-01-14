package com.blinch.server.main;

/**
 * Created by markuskopf on 13/01/16.
 */
public class RegisterRequest {

    private String name;
    private String surname;
    private String email;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
