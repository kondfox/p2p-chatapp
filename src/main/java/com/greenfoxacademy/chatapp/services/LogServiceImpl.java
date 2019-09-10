package com.greenfoxacademy.chatapp.services;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Service
public class LogServiceImpl implements LogService {

    @Override
    public void log(HttpServletRequest request) {
        System.out.printf(
                "%s INFO Request %s %s %s \n",
                LocalDateTime.now().toString(),
                request.getRequestURI(),
                request.getMethod(),
                queryString(request)
        );
    }

    @Override
    public void log(String error) {
        System.err.printf("%s ERROR %s", LocalDateTime.now().toString(), error);
    }

    private String queryString(HttpServletRequest request) {
        return request.getQueryString() != null ? request.getQueryString() : "";
    }

}
