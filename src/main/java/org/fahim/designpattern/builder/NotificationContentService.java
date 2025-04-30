package org.fahim.designpattern.builder;

import org.springframework.stereotype.Service;

@Service
public class NotificationContentService {

  public EmailNotification buildEmailNotification(User user) {
    NotificationDirector notificationDirector = new NotificationDirector();
    EmailNotificationBuilder notificationBuilder = new EmailNotificationBuilder();

    return notificationDirector.buildEmailNotificationContent(user, notificationBuilder);
  }

  public PushNotification buildPushNotification(User user) {
    NotificationDirector notificationDirector = new NotificationDirector();
    PushNotificationBuilder notificationBuilder = new PushNotificationBuilder();

    return notificationDirector.buildPushNotificationContent(user, notificationBuilder);
  }
}
