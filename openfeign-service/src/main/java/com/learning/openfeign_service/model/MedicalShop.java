package com.learning.openfeign_service.model;

import java.util.List;

public class MedicalShop {
    private String shopId;
    private String shopName;
    private String shopAddress;
    private List<Medicine> medicineList;

    public MedicalShop() {
    }

    public MedicalShop(String shopId, String shopName, String shopAddress, List<Medicine> medicineList) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.medicineList = medicineList;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }
}
