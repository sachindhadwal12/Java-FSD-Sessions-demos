package com.learning.openfeign_service.Controller;

import com.learning.openfeign_service.model.MedicalShop;
import com.learning.openfeign_service.service.FeignService;
import com.learning.openfeign_service.service.PostsService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")
@CircuitBreaker(name = "sachin" ,fallbackMethod = "getError")
public class FeignController {

    @Autowired
    private FeignService feignService;

    @Autowired
    PostsService service;

    @PostMapping("addMedicalShop")
    public ResponseEntity<?> addMedicalShop(@RequestBody MedicalShop medicalShop){
        return  new ResponseEntity<>(feignService.addMedicalShop(medicalShop), HttpStatus.CREATED);
    }

    @GetMapping("getAllMedicalShop")

    public ResponseEntity<?> getAllMedicalShop() {
        return new ResponseEntity<>(feignService.getAllMedicalShop(), HttpStatus.OK);
    }


    @GetMapping("posts")
    public ResponseEntity<?> getAllPosts() {
        return new ResponseEntity<>(service.getAllPosts(), HttpStatus.OK);
    }

    public ResponseEntity<?> getError(Throwable throwable){
        return new ResponseEntity<>("Service is down, please try again later",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
