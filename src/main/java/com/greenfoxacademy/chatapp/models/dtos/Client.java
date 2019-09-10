package com.greenfoxacademy.chatapp.models.dtos;

import javax.validation.constraints.NotNull;

public class Client {

    @NotNull
    private String id;

    public Client() {
    }

    public Client(@NotNull String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
