package com.testing;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String state;
    private  String country;

    public Address(String state, String country) {
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
