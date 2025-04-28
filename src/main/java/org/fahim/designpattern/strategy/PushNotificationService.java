package org.fahim.designpattern.strategy;

import org.springframework.stereotype.Service;

@Service
public class PushNotificationService implements NotificationStrategy {
  @Override
  public NotificationType sendNotification() {
    System.out.println("Sending push notification");
    return NotificationType.PUSH;
  }
}
