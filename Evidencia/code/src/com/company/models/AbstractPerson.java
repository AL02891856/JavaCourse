package com.company.models;

public abstract class AbstractPerson {
    String name;

    public AbstractPerson(String name) {
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
