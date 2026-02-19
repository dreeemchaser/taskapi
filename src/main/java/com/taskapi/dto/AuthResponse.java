package com.taskapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.Contract;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;

    @Contract(pure = true)
    public AuthResponse(String token, Long id, String username, String email){
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
