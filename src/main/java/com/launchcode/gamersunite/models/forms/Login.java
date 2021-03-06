package com.launchcode.gamersunite.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Login {
    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{4,20}", message = "Username must be between 4 and 20 characters, and may contain only letters and numbers")
    private String username;

    @NotNull
    @Pattern(regexp = "(\\S){4,20}", message = "Password must have 4-20 characters")
    private String password;

    public Login() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }
}


