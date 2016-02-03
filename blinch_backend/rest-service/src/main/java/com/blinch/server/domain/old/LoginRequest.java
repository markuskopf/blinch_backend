package com.blinch.server.domain.old;

/**
 * Created by markuskopf on 13/01/16.
 */
public class LoginRequest {

    private String mail;
    private String password;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
