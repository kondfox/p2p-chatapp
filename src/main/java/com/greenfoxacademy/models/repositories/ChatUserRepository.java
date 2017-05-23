package com.greenfoxacademy.models.repositories;

import com.greenfoxacademy.models.entities.ChatUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kond on 2017. 05. 23..
 */
@Repository
public interface ChatUserRepository extends CrudRepository<ChatUser, String> {
  List<ChatUser> findAll();
  long count();
  ChatUser findFirstByOrderByUsernameAsc();

}
