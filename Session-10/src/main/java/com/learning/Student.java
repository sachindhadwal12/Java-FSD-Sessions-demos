package com.learning;

import java.util.List;

public class Student {

    private String name;
    private  String email;
    private List<Hobby> hobbyList;

//    public Student(String name, String email, List<Hobby> hobbyList) {
//        this.name = name;
//        this.email = email;
//        this.hobbyList = hobbyList;
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", hobbyList=" + hobbyList +
                '}';
    }

    public void init(){
        System.out.println("I am a Iniitialization Method");
    }
    public  void destroy(){
        System.out.println("I am cleaning up");
    }



    //    private Hobby hobby;

//    public Student(String name, String email, Hobby hobby) {
//        this.name = name;
//        this.email = email;
//        this.hobby = hobby;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", hobby=" + hobby +
//                '}';
//    }
}
