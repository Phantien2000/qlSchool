package com.example.mini_project.securityConfig.jwt;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AuthRequest {
    @NotNull
    @Length(min=1, max = 50)
    private String email;
    @NotNull
    @Length(min=1, max =10)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
