package com.launchcode.gamersunite.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Register extends Login {
    @NotNull
    @Pattern(regexp = "(\\S){4,20}", message = "Password must have 4-20 characters")
    private String confirmPassword;


    public Register() {
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}


