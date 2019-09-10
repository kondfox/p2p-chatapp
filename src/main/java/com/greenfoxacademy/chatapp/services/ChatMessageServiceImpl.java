package com.greenfoxacademy.chatapp.services;

import com.greenfoxacademy.chatapp.models.dtos.Client;
import com.greenfoxacademy.chatapp.models.dtos.MessageDTO;
import com.greenfoxacademy.chatapp.models.entities.ChatMessage;
import com.greenfoxacademy.chatapp.repositories.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    private ChatMessageRepository chatMessageRepository;
    private UserService userService;
    private ForwardService forwardService;

    @Autowired
    public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository, UserService userService) {
        this.chatMessageRepository = chatMessageRepository;
        this.userService = userService;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        forwardService = retrofit.create(ForwardService.class);
    }

    @Override
    public List<ChatMessage> listMessages() {
        return chatMessageRepository.findAll();
    }

    @Override
    public void send(String text) {
        ChatMessage message = new ChatMessage(userService.getUser().getName(), text);
        chatMessageRepository.save(message);
        MessageDTO messageDTO = new MessageDTO(message, new Client(System.getenv("CHAT_APP_UNIQUE_ID")));
        forwardService.forwardMessage(messageDTO);
    }

    @Override
    public void send(MessageDTO message) {
        if (!message.getClient().getId().equals(System.getenv("CHAT_APP_UNIQUE_ID"))) {
            chatMessageRepository.save(message.getMessage());
            forwardService.forwardMessage(message);
        }
    }

}
