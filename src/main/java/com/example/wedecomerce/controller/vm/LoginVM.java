package com.example.wedecomerce.controller.vm;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginVM {
    @NotNull
    @Size(min = 3, max = 50)
    private String login;

    @NotNull
    @Size(min = 1, max = 100)
    private String password;

    private boolean rememberMe;

    @Override
    public String toString() {
        return "LoginVM{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                '}';
    }
}
