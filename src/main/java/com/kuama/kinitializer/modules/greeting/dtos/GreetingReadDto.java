package com.kuama.kinitializer.modules.greeting.dtos;

public class GreetingReadDto {
    private Long Id;

    private String Title;

    private String Message;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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
        return "GreetingReadDto{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}
