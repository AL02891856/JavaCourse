package com.company;

public class Card {
    String value;
    String color;
    String figure;

    public Card(String value, String color, String figure) {
        this.value = value;
        this.color = color;
        this.figure = figure;
    }

    public String GetValue() {
        return this.value;
    }

    public String GetColor() {
        return this.color;
    }

    public String GetFigure() {
        return this.figure;
    }

    public String toString() {
        return this.figure + " "
                + this.color + " "
                + this.value;
    }
}