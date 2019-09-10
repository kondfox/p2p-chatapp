package com.greenfoxacademy.chatapp.services;

import com.greenfoxacademy.chatapp.models.dtos.MessageDTO;
import com.greenfoxacademy.chatapp.models.entities.ChatMessage;

import java.util.List;

public interface ChatMessageService {

    List<ChatMessage> listMessages();
    void send(String message);
    void send(MessageDTO message);

}
