package com.taskapi.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Password is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

}
