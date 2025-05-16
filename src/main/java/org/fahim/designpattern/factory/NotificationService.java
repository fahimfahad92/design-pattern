package org.fahim.designpattern.factory;

import org.springframework.stereotype.Service;

@Service("NotificationServiceForFactory")
public class NotificationService {

  private final NotificationFactory factory;

  public NotificationService(NotificationFactory factory) {
    this.factory = factory;
  }

  public String sendNotification(User user, NotificationType type) {

    Notification notification = factory.createNotification(type);
    return notification.sendNotification(user);
  }
}
