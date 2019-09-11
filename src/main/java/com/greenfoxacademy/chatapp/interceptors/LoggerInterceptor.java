package com.greenfoxacademy.chatapp.interceptors;

import com.greenfoxacademy.chatapp.services.LogService;
import com.greenfoxacademy.chatapp.services.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private LogService logService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logService.log(request);
        return super.preHandle(request, response, handler);
    }

}
