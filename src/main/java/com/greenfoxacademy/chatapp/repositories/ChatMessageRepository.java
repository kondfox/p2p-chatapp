package com.greenfoxacademy.chatapp.repositories;

import com.greenfoxacademy.chatapp.models.entities.ChatMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Integer> {

    List<ChatMessage> findAll();

    @Query(value = "SELECT * FROM chat_message ORDER BY timestamp DESC", nativeQuery = true)
    List<ChatMessage> findAllOrderedByTimeDesc();

}
