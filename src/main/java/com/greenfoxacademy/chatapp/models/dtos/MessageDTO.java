package com.greenfoxacademy.chatapp.models.dtos;

import com.greenfoxacademy.chatapp.models.entities.ChatMessage;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MessageDTO {

    @Valid
    @NotNull
    private ChatMessage message;
    @Valid
    @NotNull
    private Client client;

    public MessageDTO() {
    }

    public MessageDTO(@Valid @NotNull ChatMessage message, @Valid @NotNull Client client) {
        this.message = message;
        this.client = client;
    }

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
