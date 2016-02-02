package com.blinch.server.domain;

/**
 * Created by markuskopf on 13/01/16.
 */
public class LogoutResponse {
    private String message;
    private int status;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
