package org.fahim.designpattern.decorator;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

  private final EmailNotificationHandler emailNotificationHandler;

  public NotificationService(EmailNotificationHandler emailNotificationHandler) {
    this.emailNotificationHandler = emailNotificationHandler;
  }

  public String sendNotification(String to, NotificationSettings notificationSettings) {
    Notifier notifier = new DefaultNotification();

    if (notificationSettings.email()) {
      notifier = new EmailNotificationDecorator(notifier, emailNotificationHandler);
    }

    if (notificationSettings.push()) {
      notifier = new PushNotificationDecorator(notifier);
    }

    if (notificationSettings.inApp()) {
      notifier = new InAppNotificationDecorator(notifier);
    }

    return notifier.sendNotification("", to);
  }
}
