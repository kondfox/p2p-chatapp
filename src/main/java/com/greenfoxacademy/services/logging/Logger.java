package com.greenfoxacademy.services.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by kond on 2017. 05. 22..
 */
public class Logger {
  private static final String logFormat = "%s %s Request %s %s %s\n";

  public static void logInfo(String endpoint, String method) {
    log("INFO", endpoint, method, null);
  }

  public static void logInfo(String endpoint, String method, Object obj) {
    log("INFO", endpoint, method, obj);
  }

  public static void logError(String endpoint, String method) {
    log("ERROR", endpoint, method, null);
  }

  public static void logError(String endpoint, String method, Object obj) {
    log("ERROR", endpoint, method, null);
  }

  private static void log(String type, String endpoint, String method, Object obj) {
    if (System.getenv().get("CHAT_APP_LOGLEVEL").equals("ERROR") && type.equals("INFO")) {
      return;
    }
    String paramsString = "";
    if (obj != null) {
      paramsString = obj.toString();
    }
    if (type.equals("INFO")) {
      System.out.printf(
              logFormat,
              DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(LocalDateTime.now()),
              "INFO",
              endpoint,
              method,
              paramsString
      );
    } else {
      System.err.printf(
              logFormat,
              DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(LocalDateTime.now()),
              "INFO",
              endpoint,
              method,
              paramsString
      );
    }
  }

}
