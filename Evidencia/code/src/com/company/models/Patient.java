package com.company.models;

public class Patient extends AbstractPerson{
    String gender;
    int age;

    public Patient(int id, String name, String gender, int age) {
        super(id, name);
        this.gender = gender;
        this.age = age;
    }
}
