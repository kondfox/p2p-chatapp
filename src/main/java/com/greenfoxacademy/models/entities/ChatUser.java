package com.greenfoxacademy.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kond on 2017. 05. 23..
 */
@Entity
@Table(name = "ChatUser")
public class ChatUser {
  @Column(name = "username")
  @Id
  String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "username=" + this.username;
  }
}
