package com.greenfoxacademy.models.errors;

/**
 * Created by kond on 2017. 05. 23..
 */
public class FormError {
  private String error;

  public FormError(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
