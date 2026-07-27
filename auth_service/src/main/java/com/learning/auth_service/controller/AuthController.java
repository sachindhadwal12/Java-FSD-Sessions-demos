package com.learning.auth_service.controller;

import com.learning.auth_service.dto.CommonResponse;
import com.learning.auth_service.dto.RegisterRequest;
import com.learning.auth_service.secuirty.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<CommonResponse> register(@Valid @RequestBody RegisterRequest request){
        return new ResponseEntity<>(authService.register(request), ResponseEntity.ok()
                .build().getStatusCode());
    }

}
