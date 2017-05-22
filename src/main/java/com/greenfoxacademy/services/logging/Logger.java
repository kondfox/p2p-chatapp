package com.greenfoxacademy.services.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kond on 2017. 05. 22..
 */
public class Logger {
  private static final String logFormat = "%s %s Request %s %s%s";

  public static void log(String endpoint, String method) {
    log(endpoint, method, null);
  }

  public static void log(String endpoint, String method, Map<String, String> params) {
    if (!System.getenv().get("CHAT_APP_LOGLEVEL").equals("INFO")) {
      return;
    }
    String paramsString = "";
    if (params != null) {
      for (String key : params.keySet()) {
        paramsString += " " + key + "=" + params.get(key);
      }
    }
    System.out.printf(
            logFormat,
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()),
            "INFO",
            endpoint,
            method,
            paramsString
    );
  }
}
