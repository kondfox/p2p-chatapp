package com.greenfoxacademy.chatapp.repositories;

import com.greenfoxacademy.chatapp.models.entities.ChatMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Integer> {

    List<ChatMessage> findAll();

    @Query(value = "SELECT * FROM chat_message ORDER BY timestamp DESC", nativeQuery = true)
    List<ChatMessage> findAllOrderedByTimeDesc();

    @Query(value = "SELECT * FROM chat_message WHERE timestamp = ?1", nativeQuery = true)
    List<ChatMessage> findMessagesWithTimestamp(long timestamp);

}
