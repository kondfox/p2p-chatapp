package com.greenfoxacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kond on 2017. 05. 22..
 */
@Controller
public class MainController {

  @GetMapping("/")
  public String index() {
    return "index";
  }

}
