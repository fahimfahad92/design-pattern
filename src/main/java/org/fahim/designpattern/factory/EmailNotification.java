package org.fahim.designpattern.factory;

import org.springframework.stereotype.Service;

@Service
public class EmailNotification implements Notification {

  @Override
  public String sendNotification(User user) {
    return "Sending email notification to " + user.email();
  }
}
