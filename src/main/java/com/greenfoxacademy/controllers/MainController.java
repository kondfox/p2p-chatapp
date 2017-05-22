package com.greenfoxacademy.controllers;

import com.greenfoxacademy.services.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kond on 2017. 05. 22..
 */
@Controller
public class MainController {

  @GetMapping("/")
  public String index() {
    Logger.log("/", "GET");
    return "index";
  }

}
