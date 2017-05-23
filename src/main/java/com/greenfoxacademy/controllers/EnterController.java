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
 * Created by kond on 2017. 05. 23..
 */
@Controller
public class EnterController {

  @Autowired
  UserService userService;

  @GetMapping("/enter")
  public ModelAndView enter(ModelAndView m) {
    Logger.logInfo("/enter", "GET");
    if (!userService.isEmpty()) {
      m.setViewName("redirect:/");
    }
    m = setEnterModelAndView(m);
    return m;
  }

  @PostMapping("/enter")
  public ModelAndView enterForm(ModelAndView m, @ModelAttribute ChatUser user) {
    Logger.logInfo("/enter", "POST", user);
    if (user.getUsername().length() == 0) {
      m = setEnterModelAndView(m);
      m.addObject("formError", new FormError("The username field is empty"));
      return m;
    } else if (!userService.save(user)) {
      m = setEnterModelAndView(m);
      m.addObject("formError", new FormError("Error: couldn't save to database"));
      return m;
    }
    m.setViewName("redirect:/");
    return m;
  }

  private ModelAndView setEnterModelAndView(ModelAndView m) {
    m.setViewName("enter");
    m.addObject("chatUser", new ChatUser());
    return m;
  }

}
