package com.learning.embededdocumentdemo.services;

import com.learning.embededdocumentdemo.exception.MedicineIdAlreadyExistException;
import com.learning.embededdocumentdemo.exception.MedicineNameNotFoundException;
import com.learning.embededdocumentdemo.model.Medicine;
import com.learning.embededdocumentdemo.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineImpl implements MedicineDdao{

    private MedicineRepository repository;

    public MedicineImpl(MedicineRepository repository) {
        this.repository = repository;
    }

    @Override
    public Medicine addMedicine(Medicine medicine) throws MedicineIdAlreadyExistException {
        Optional<Medicine> optional = repository.findById(medicine.getMedId());
        if (optional.isPresent()){
            throw new MedicineIdAlreadyExistException
                    ("Medicine with id "+ medicine.getMedId() +" already exist in DB");
        }
        return repository.save(medicine);
    }

    @Override
    public List<Medicine> getAllMedicine() {
        return repository.findAll();
    }

    @Override
    public Medicine getMedicineByName(String name) throws MedicineNameNotFoundException {
        Medicine medicine = repository.findByMedName(name);
        if(medicine==null){
            throw new MedicineNameNotFoundException
                    ("Medicine with Name "+name+ "does not exist in DB ");
        }
        return medicine;
    }

    @Override
    public List<Medicine> getMedicinePriceGreaterThan(int price) {
        return repository.findByPriceGreaterThan(price);
    }
}
