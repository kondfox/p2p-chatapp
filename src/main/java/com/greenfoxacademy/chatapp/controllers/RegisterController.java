package com.greenfoxacademy.chatapp.controllers;

import com.greenfoxacademy.chatapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String renderRegisterPage() {
        if (userService.getUser() != null) {
            return "redirect:/";
        } else {
            return "register";
        }
    }

    @PostMapping
    public String register(@RequestParam(value = "username") String username, Model model) {
        if (username.isEmpty()) {
            model.addAttribute("error", "The username field is empty");
            return "register";
        } else {
            userService.register(username);
            return "redirect:/";
        }
    }

}
