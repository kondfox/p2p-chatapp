package com.greenfoxacademy.chatapp.services;

import com.greenfoxacademy.chatapp.models.entities.ChatMessage;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class WSService {

  @SendTo("/messages/refresh")
  public ChatMessage broadCastNewMessage(ChatMessage chatMessage) {
    System.out.println("broadCastNewMessage: " + chatMessage);
    return chatMessage;
  }

}
