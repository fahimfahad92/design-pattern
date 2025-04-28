package org.fahim.designpattern.strategy;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationStrategy {
  @Override
  public NotificationType sendNotification() {
    System.out.println("Sending email notification");
    return NotificationType.EMAIL;
  }
}
