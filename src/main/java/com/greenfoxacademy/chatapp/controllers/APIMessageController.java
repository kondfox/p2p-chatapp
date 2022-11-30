package com.greenfoxacademy.chatapp.controllers;

import com.greenfoxacademy.chatapp.models.dtos.MessageDTO;
import com.greenfoxacademy.chatapp.models.dtos.StatusMessage;
import com.greenfoxacademy.chatapp.models.dtos.StatusMessageOK;
import com.greenfoxacademy.chatapp.services.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/message")
public class APIMessageController {

    private ChatMessageService messageService;

    @Autowired
    public APIMessageController(ChatMessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/receive")
    public ResponseEntity<StatusMessage> receiveMessage(@Valid @RequestBody MessageDTO messageDTO) {
        messageService.send(messageDTO);
        return ResponseEntity.status(200).body(new StatusMessageOK());
    }

}
