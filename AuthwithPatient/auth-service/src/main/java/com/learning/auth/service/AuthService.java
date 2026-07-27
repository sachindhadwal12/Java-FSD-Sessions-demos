package com.learning.auth.service;

import com.learning.auth.dto.*;
import com.learning.auth.entity.*;
import com.learning.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository        userRepository;
    private final PasswordEncoder       passwordEncoder;
    private final JwtService            jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService    userDetailsService;

    // ── Register ──────────────────────────────────────────────────────────────
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException(
                    "Username already taken: " + request.getUsername());
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole() != null ? request.getRole() : Role.ROLE_USER)
                .build();

        userRepository.save(user);

        // No token on register — use /login to get a token
        return new AuthResponse(user.getUsername(), null, user.getRole().name(), "Registration successful");
    }

    // ── Login ─────────────────────────────────────────────────────────────────
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()));

        var userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token    = jwtService.generateToken(userDetails);
        String role     = userDetails.getAuthorities().iterator().next().getAuthority();

        // username is null → hidden from JSON by @JsonInclude(NON_NULL)
        return new AuthResponse(null, token, role, "Login successful");
    }
}