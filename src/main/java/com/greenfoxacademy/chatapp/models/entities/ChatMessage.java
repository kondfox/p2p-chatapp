package com.greenfoxacademy.chatapp.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class ChatMessage {

    @Id
    @NotNull
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    private String text;
    @NotNull
    private Long timestamp;

    public ChatMessage() {
    }

    public ChatMessage(String username, String text) {
        this.id = (int) (1000000 + Math.random() * 9000000);
        this.username = username;
        this.text = text;
        this.timestamp = new Date().getTime() / 1000;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
