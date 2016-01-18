package com.blinch.server.domain;

/**
 * Created by markuskopf on 13/01/16.
 */
public class HistoryResponse extends  DefaultResponse {

    private BlinchAppointment[] appointments;


    public BlinchAppointment[] getAppointments() {
        return appointments;
    }

    public void setAppointments(BlinchAppointment[] appointments) {
        this.appointments = appointments;
    }

}
