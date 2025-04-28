package org.fahim.designpattern.strategy;

import org.springframework.stereotype.Service;

@Service
public class InAppNotificationService implements NotificationStrategy {
  @Override
  public NotificationType sendNotification() {
    System.out.println("Sending in-app notification");
    return NotificationType.IN_APP;
  }
}
