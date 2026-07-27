package com.learning.auth.controller;

import com.learning.auth.dto.*;
import com.learning.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * POST /api/v1/auth/register
     *
     * Body:
     * {
     *   "username": "alice",
     *   "password": "secret",
     *   "role": "ROLE_USER"      ← optional, defaults to ROLE_USER
     * }
     *
     * Response:
     * {
     *   "token": "eyJhbGciOiJIUzI1NiJ9...",
     *   "role": "ROLE_USER",
     *   "message": "Registration successful"
     * }
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    /**
     * POST /api/v1/auth/login
     *
     * Body:
     * {
     *   "username": "alice",
     *   "password": "secret"
     * }
     *
     * Response:
     * {
     *   "token": "eyJhbGciOiJIUzI1NiJ9...",
     *   "role": "ROLE_ADMIN",
     *   "message": "Login successful"
     * }
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
