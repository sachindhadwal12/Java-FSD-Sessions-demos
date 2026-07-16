package com.learning.embededdocumentdemo.controller;

import com.learning.embededdocumentdemo.exception.MedicineIdAlreadyExistException;
import com.learning.embededdocumentdemo.model.Medicine;
import com.learning.embededdocumentdemo.services.MedicineImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/medicine")
public class MedicineController {

    private MedicineImpl service;

    public MedicineController(MedicineImpl service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> saveMedicine(@RequestBody Medicine medicine) throws MedicineIdAlreadyExistException {
        return new ResponseEntity<>(service.addMedicine(medicine), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllMedicines(){
        return new ResponseEntity<>(service.getAllMedicine(),HttpStatus.OK);
    }

}
