package com.kuama.kinitializer.modules.greeting.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long Id;

    @Column(name = "title", nullable = false)
    public String Title;

    @Column(name = "message", nullable = false)
    public String Message;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Greeting greeting)) return false;
        return getId().equals(greeting.getId())
                && getTitle().equals(greeting.getTitle())
                && getMessage().equals(greeting.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getMessage());
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}
