package org.example;

import java.util.Date;

public class Grade {
    private double value;
    private Date date;

    public Grade(double value) {
        this.value = value;
        this.date = new Date();
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}
