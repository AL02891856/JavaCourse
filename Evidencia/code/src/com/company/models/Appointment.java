package com.company.models;

import java.util.Date;

public class Appointment {
    int id;
    int idDoctor;
    int idPatient;
    String description;
    Date date;

    public Appointment(int idDoctor, int idPatient, String description, Date date) {
        this.idDoctor = idDoctor;
        this.idPatient = idPatient;
        this.description = description;
        this.date = date;
    }
}
