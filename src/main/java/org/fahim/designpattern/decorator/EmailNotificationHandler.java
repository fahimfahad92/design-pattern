package org.fahim.designpattern.decorator;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationHandler {

  public String sendNotification(String message, String to) {
    System.out.println("Email sent to " + to);
    if (message == null || message.isEmpty()) {
      return "Email";
    }
    return message + " , Email";
  }
}
