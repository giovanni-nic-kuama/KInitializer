package com.kuama.kinitializer.modules.authentication.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailAndPasswordDto {

    @JsonProperty("email")
    String email;

    @JsonProperty("password")
    String password;

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
