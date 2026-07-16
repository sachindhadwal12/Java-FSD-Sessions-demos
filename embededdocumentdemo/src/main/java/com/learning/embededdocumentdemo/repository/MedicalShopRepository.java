package com.learning.embededdocumentdemo.repository;

import com.learning.embededdocumentdemo.model.MedicalShop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalShopRepository extends MongoRepository<MedicalShop,String> {
    List<MedicalShop> findByShopAddress(String address);
}
