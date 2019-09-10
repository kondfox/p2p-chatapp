package com.greenfoxacademy.chatapp.services;

import com.greenfoxacademy.chatapp.models.entities.ChatUser;
import com.greenfoxacademy.chatapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ChatUser register(String username) {
        return userRepository.save(new ChatUser(username));
    }

    @Override
    public ChatUser getUser() {
        if (userRepository.existsById(1L)) {
            return userRepository.findById(1L).get();
        }
        return null;
    }

    @Override
    @Transactional
    public void changeName(String newName) {
        userRepository.updateName(newName);
    }

}
