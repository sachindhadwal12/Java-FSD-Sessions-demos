package com.learning;

import org.springframework.stereotype.Component;

@Component
public class Hobby {
    private String hobbyName;
    private String startDate;

    public Hobby(String hobbyName, String startDate) {
        this.hobbyName = hobbyName;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyName='" + hobbyName + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
