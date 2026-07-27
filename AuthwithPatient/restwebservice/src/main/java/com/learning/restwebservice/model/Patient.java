package com.learning.restwebservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Patient {
    @Id
    private long id;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 15 , message = "Minimum 3 Character and maximum 15 character allowed")
    private String name;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "Problem is required")
    private String problem;

    public Patient() {
    }

    public Patient(long id, String name, String address, String problem) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.problem = problem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
