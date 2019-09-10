package com.greenfoxacademy.chatapp.services;

import com.greenfoxacademy.chatapp.models.dtos.Client;
import com.greenfoxacademy.chatapp.models.dtos.MessageDTO;
import com.greenfoxacademy.chatapp.models.entities.ChatMessage;
import com.greenfoxacademy.chatapp.repositories.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    private ChatMessageRepository chatMessageRepository;
    private UserService userService;
    private ForwardService forwardService;
    private LogService logService;
    private String forwardUrl;

    @Autowired
    public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository, UserService userService, LogService logService) {
        this.chatMessageRepository = chatMessageRepository;
        this.userService = userService;
        this.logService = logService;
    }

    @Override
    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(forwardUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        forwardService = retrofit.create(ForwardService.class);
    }

    @Override
    public String getForwardUrl() {
        return this.forwardUrl;
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
        forward(messageDTO);
    }

    @Override
    public void send(MessageDTO message) {
        if (!message.getClient().getId().equals(System.getenv("CHAT_APP_UNIQUE_ID"))) {
            chatMessageRepository.save(message.getMessage());
            forward(message);
        }
    }

    private void forward(MessageDTO message) {
        try {
            forwardService.forwardMessage(message).execute();
        } catch (IOException e) {
            logService.log("Error during forwarding the message.");
        } catch (NullPointerException e) {
            logService.log("Forward URL hasn't been set yet.");
        }
    }

}
