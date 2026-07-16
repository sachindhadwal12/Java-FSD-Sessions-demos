package com.learning.embededdocumentdemo.services;

import com.learning.embededdocumentdemo.exception.MedicalShopDoesNotFoundException;
import com.learning.embededdocumentdemo.exception.MedicalShopIdAlreadyExistException;
import com.learning.embededdocumentdemo.exception.MedicineIdNotFoundException;
import com.learning.embededdocumentdemo.model.MedicalShop;
import com.learning.embededdocumentdemo.model.Medicine;

import java.util.List;

public interface MedicalShopDao {
    public MedicalShop addMedicalShop(MedicalShop medicalShop) ;
    public List<MedicalShop> getAllMedicalShop();
    public MedicalShop addMedicineToMedicalShop(String shopId, Medicine medicine) throws MedicalShopDoesNotFoundException;
    public List<MedicalShop> getMedicalShopByAddress(String shopAddress);
    public Boolean deleteMedicineFromMedicalShop(String shopId,String medId) throws MedicineIdNotFoundException,
            MedicalShopDoesNotFoundException;
}
