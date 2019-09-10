package com.greenfoxacademy.chatapp.repositories;

import com.greenfoxacademy.chatapp.models.entities.ChatUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<ChatUser, Long> {

    @Modifying
    @Query("update ChatUser u set u.name = :username where u.id = 1")
    void updateName(String username);

}
