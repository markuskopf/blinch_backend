package com.blinch.server.domain;

import java.util.Date;

/**
 * Created by markuskopf on 13/01/16.
 */
public class CheckinResponse extends DefaultResponse {

    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
