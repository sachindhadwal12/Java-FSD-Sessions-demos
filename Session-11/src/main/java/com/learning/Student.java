package com.learning;

import com.testing.Address;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {
    private  String name;
    private String email;
    private List<Hobby> hobbyList;
    private Address address;

    public Student(String name, String email, List<Hobby> hobbyList, Address address) {
        this.name = name;
        this.email = email;
        this.hobbyList = hobbyList;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", hobbyList=" + hobbyList +
                ", address=" + address +
                '}';
    }

//    public Student(String name, String email, List<Hobby> hobbyList) {
//        this.name = name;
//        this.email = email;
//        this.hobbyList = hobbyList;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", hobbyList=" + hobbyList +
//                '}';
//    }
}
