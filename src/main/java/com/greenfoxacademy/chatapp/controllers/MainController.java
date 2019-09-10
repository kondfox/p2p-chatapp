package com.greenfoxacademy.chatapp.controllers;

import com.greenfoxacademy.chatapp.models.entities.ChatUser;
import com.greenfoxacademy.chatapp.services.ChatMessageService;
import com.greenfoxacademy.chatapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

    private UserService userService;
    private ChatMessageService messageService;

    @Autowired
    public MainController(UserService userService, ChatMessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping
    public String renderIndexPage(Model model) {
        ChatUser user = userService.getUser();
        if (user == null) {
            return "redirect:/register";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("messages", messageService.listMessages());
            return "index";
        }
    }

    @PostMapping
    public String changeUsername(@RequestParam String username, Model model) {
        if (username.isEmpty()) {
            model.addAttribute("error", "The username field is empty");
        } else {
            userService.changeName(username);
        }
        model.addAttribute("user", userService.getUser());
        return "index";
    }

}
