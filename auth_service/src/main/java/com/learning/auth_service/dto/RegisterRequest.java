package com.learning.auth_service.dto;

import com.learning.auth_service.model.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
   @NotBlank(message = "Username is required")
    private String username;
   @NotBlank(message = "Password is required")
    private String password;

    // Optional - default Role_USER

    private Role role = Role.ROLE_USER;
}
