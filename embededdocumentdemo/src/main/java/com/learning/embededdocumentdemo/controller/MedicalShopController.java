package com.learning.embededdocumentdemo.controller;

import com.learning.embededdocumentdemo.exception.MedicalShopDoesNotFoundException;
import com.learning.embededdocumentdemo.model.MedicalShop;
import com.learning.embededdocumentdemo.model.Medicine;
import com.learning.embededdocumentdemo.services.MedicalShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/pharamcy")
public class MedicalShopController {
    private MedicalShopService service;

    public MedicalShopController(MedicalShopService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> addMedicine(@RequestBody MedicalShop medicalShop){
        return new ResponseEntity<>(service.addMedicalShop(medicalShop), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllMedicalShop(){
        return new ResponseEntity<>(service.getAllMedicalShop(),HttpStatus.OK);
    }

    @PostMapping("/addMedicineToMedicalShop/{shopId}")
    public ResponseEntity<?> addMedicineToMedicalShop(@PathVariable String shopId, @RequestBody Medicine medicine) throws MedicalShopDoesNotFoundException {
        MedicalShop shop = service.addMedicineToMedicalShop(shopId,medicine);
        return new ResponseEntity<>(shop,HttpStatus.CREATED);
    }

    @GetMapping("getMedicalShopByAddress/{shopAddress}")
    public ResponseEntity<?> getMedicalShopsByAddress(@PathVariable String shopAddress){
        return new ResponseEntity<>(service.getMedicalShopByAddress(shopAddress),HttpStatus.OK);
    }



}
