package com.greenfoxacademy.chatapp.services;

import javax.servlet.http.HttpServletRequest;

public interface LogService {

    void log(HttpServletRequest request);
    void log(String error);

}
