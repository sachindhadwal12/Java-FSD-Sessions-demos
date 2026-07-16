package com.learning.embededdocumentdemo.repository;

import com.learning.embededdocumentdemo.model.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends MongoRepository<Medicine,String> {
    public Medicine findByMedName(String name);
    public List<Medicine> findByPriceGreaterThan(int price);
}
