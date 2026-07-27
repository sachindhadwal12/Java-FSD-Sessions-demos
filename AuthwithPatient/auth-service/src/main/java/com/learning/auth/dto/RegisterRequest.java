package com.learning.auth.dto;

import com.learning.auth.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    /**
     * Optional – defaults to ROLE_USER.
     * Pass ROLE_ADMIN to create an admin account.
     */
    private Role role = Role.ROLE_USER;
}
