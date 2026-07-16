package com.learning.embededdocumentdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Medicine {
    @Id
    private  String medId;
    private String medName;
    private int price;
    private String description;

    public Medicine() {
    }

    public Medicine(String medId, String medName, int price, String description) {
        this.medId = medId;
        this.medName = medName;
        this.price = price;
        this.description = description;
    }

    public String getMedId() {
        return medId;
    }

    public void setMedId(String medId) {
        this.medId = medId;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
