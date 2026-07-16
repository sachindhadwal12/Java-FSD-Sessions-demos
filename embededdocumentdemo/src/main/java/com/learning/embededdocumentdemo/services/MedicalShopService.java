package com.learning.embededdocumentdemo.services;


import com.learning.embededdocumentdemo.exception.MedicalShopDoesNotFoundException;
import com.learning.embededdocumentdemo.exception.MedicalShopIdAlreadyExistException;
import com.learning.embededdocumentdemo.exception.MedicineIdNotFoundException;
import com.learning.embededdocumentdemo.model.MedicalShop;
import com.learning.embededdocumentdemo.model.Medicine;
import com.learning.embededdocumentdemo.repository.MedicalShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalShopService implements MedicalShopDao {

    private MedicalShopRepository repository;

    public MedicalShopService(MedicalShopRepository repository) {
        this.repository = repository;
    }

    @Override
    public MedicalShop addMedicalShop(MedicalShop medicalShop) {
        Optional<MedicalShop> optional = repository.findById(medicalShop.getShopId());
        if(optional.isEmpty()){
            return repository.save(medicalShop);
        }
        else {
            MedicalShop medicalShop1 = optional.get();
            List<Medicine> existingMedicines = medicalShop1.getMedicineList();
            List<Medicine> newMedicines = medicalShop.getMedicineList();
            existingMedicines.addAll(newMedicines);
            medicalShop1.setMedicineList(existingMedicines);
            return repository.save(medicalShop1);
        }

    }

    @Override
    public List<MedicalShop> getAllMedicalShop() {
        return repository.findAll();
    }

    @Override
    public MedicalShop addMedicineToMedicalShop(String shopId, Medicine medicine)
            throws MedicalShopDoesNotFoundException {
      Optional<MedicalShop> optional = repository.findById(shopId);
      if(optional.isEmpty()){
          throw new MedicalShopDoesNotFoundException("Medical Shop with Id "+ shopId+ " does not exist in DB !!");
      }
        else {
            MedicalShop medShop = optional.get();
            List<Medicine> existingMedicines = medShop.getMedicineList();
            existingMedicines.add(medicine);
            medShop.setMedicineList(existingMedicines);
            return repository.save(medShop);
      }

    }

    @Override
    public List<MedicalShop> getMedicalShopByAddress(String shopAddress) {
        return repository.findByShopAddress(shopAddress);
    }

    @Override
    public Boolean deleteMedicineFromMedicalShop(String shopId, String medId) throws MedicineIdNotFoundException, MedicalShopDoesNotFoundException {
      Optional<MedicalShop> optionalMedicalShop = repository.findById(shopId);
      if(optionalMedicalShop.isEmpty()){
          throw new MedicalShopDoesNotFoundException("MedicalShop with Id" + shopId + "does exist in DB");

      }
      else {
          MedicalShop shop = optionalMedicalShop.get();
          List<Medicine> existMedicines = shop.getMedicineList();
          existMedicines.removeIf(medicine ->  medicine.getMedId().equals(medId));
          shop.setMedicineList(existMedicines);
          repository.save(shop);
          return true;
      }
    }
}
