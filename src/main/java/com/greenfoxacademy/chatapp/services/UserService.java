package com.greenfoxacademy.chatapp.services;

import com.greenfoxacademy.chatapp.models.entities.ChatUser;

public interface UserService {

    ChatUser register(String username);
    ChatUser getUser();
    void changeName(String newName);

}
