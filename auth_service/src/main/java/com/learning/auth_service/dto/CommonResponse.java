package com.learning.auth_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // hides null fields in response
public class CommonResponse {

    private String username; //
    private String token;   //should be populated only in login
    private String role;
    private String message;
}
