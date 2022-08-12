package com.kuama.kinitializer.modules.greeting.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GreetingUpdateDto {

    @JsonProperty("title")
    private String Title;

    @JsonProperty("message")
    private String Message;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "GreetingUpdateDto{" +
                "Title='" + Title + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}
