package com.greenfoxacademy.chatapp.interceptors;

import com.greenfoxacademy.chatapp.services.LogServiceImpl;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        new LogServiceImpl().log(request);
        return super.preHandle(request, response, handler);
    }

}
