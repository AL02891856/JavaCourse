package com.company.models;

public abstract class AbstractPerson {
    int id;
    String name;

    public AbstractPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public AbstractPerson() { }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
