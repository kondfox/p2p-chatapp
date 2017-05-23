package com.greenfoxacademy.controllers;

import com.greenfoxacademy.models.entities.ChatUser;
import com.greenfoxacademy.models.errors.FormError;
import com.greenfoxacademy.services.UserService;
import com.greenfoxacademy.services.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kond on 2017. 05. 22..
 */
@Controller
public class MainController {

  @Autowired
  private UserService userService;

  private ChatUser currentUser;

  @GetMapping("/")
  public ModelAndView index(ModelAndView m) {
    Logger.logInfo("/", "GET");
    if (userService.isEmpty()) {
      m.setViewName("redirect:/enter");
      return m;
    }
    m.setViewName("index");
    currentUser = userService.getFirst();
    m.addObject("chatUser", currentUser);
    return m;
  }

  @PostMapping("/")
  public ModelAndView indexForm(ModelAndView m, @ModelAttribute ChatUser user) {
    Logger.logInfo("/", "POST", user);
    m.setViewName("index");
    m.addObject("chatUser", user);
    if (user.getUsername().length() == 0) {
      m.addObject("formError", new FormError("The username field is empty"));
      return m;
    } else {
      userService.switchUser(currentUser, user);
      currentUser = user;
      return m;
    }
  }

}
