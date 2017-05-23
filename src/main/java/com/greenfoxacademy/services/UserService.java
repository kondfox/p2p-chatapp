package com.greenfoxacademy.services;

import com.greenfoxacademy.models.entities.ChatUser;
import com.greenfoxacademy.models.repositories.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kond on 2017. 05. 23..
 */
@Service
public class UserService {

  @Autowired
  private ChatUserRepository userRepository;

  public boolean save(ChatUser user) {
    try {
      userRepository.save(user);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public List<ChatUser> getUsers() {
    try {
      return userRepository.findAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  public boolean isEmpty() {
    if (userRepository.count() > 0) {
      return false;
    } else {
      return true;
    }
  }

  public ChatUser getFirst() {
    return userRepository.findFirstByOrderByUsernameAsc();
  }

  public void delete(ChatUser user) {
    userRepository.delete(user.getUsername());
  }

  public void switchUser(ChatUser previousUser, ChatUser newUser) {
    delete(previousUser);
    save(newUser);
  }

}
