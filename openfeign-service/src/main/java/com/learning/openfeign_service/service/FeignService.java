package com.learning.openfeign_service.service;

import com.learning.openfeign_service.model.MedicalShop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "embededdocumentdemo",url = "http://localhost:8083/")
public interface FeignService {

    @GetMapping("api/v1/pharamcy")
    public List<MedicalShop> getAllMedicalShop();

    @PostMapping("api/v1/pharamcy")
    public MedicalShop addMedicalShop(@RequestBody MedicalShop medicalShop);

}
