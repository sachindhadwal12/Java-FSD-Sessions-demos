package com.learning.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  // hides null fields from JSON response
public class AuthResponse {

    private String username;  // populated on register
    private String token;     // populated on login only
    private String role;
    private String message;
}