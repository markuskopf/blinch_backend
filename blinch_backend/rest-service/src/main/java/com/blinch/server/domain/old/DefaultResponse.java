package com.blinch.server.domain.old;

/**
 * Created by markuskopf on 13/01/16.
 */
public class DefaultResponse {

    private int status;
    private String message;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
