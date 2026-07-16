package com.learning.embededdocumentdemo.services;

import com.learning.embededdocumentdemo.exception.MedicineIdAlreadyExistException;
import com.learning.embededdocumentdemo.exception.MedicineNameNotFoundException;
import com.learning.embededdocumentdemo.model.Medicine;

import java.util.List;

public interface MedicineDdao {
    public Medicine addMedicine(Medicine medicine) throws MedicineIdAlreadyExistException;
    public List<Medicine> getAllMedicine();
    public Medicine getMedicineByName(String name) throws MedicineNameNotFoundException;
    public List<Medicine> getMedicinePriceGreaterThan(int price);
}
