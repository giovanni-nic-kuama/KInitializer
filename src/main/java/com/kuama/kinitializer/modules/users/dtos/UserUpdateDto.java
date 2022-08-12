package com.kuama.kinitializer.modules.users.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateDto  {
    @JsonProperty("username")
    private String userName;

    @JsonProperty("email")
    private String email;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserUpdateDto{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
