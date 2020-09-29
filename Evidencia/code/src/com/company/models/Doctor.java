package com.company.models;

public class Doctor extends AbstractPerson{
    String specialty;

    public Doctor(int id, String name, String specialty) {
        super(id, name);
        this.specialty = specialty;
    }
}
