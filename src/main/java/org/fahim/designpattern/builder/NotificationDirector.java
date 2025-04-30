package org.fahim.designpattern.builder;

public class NotificationDirector {

  public EmailNotification buildEmailNotificationContent(
      User user, EmailNotificationBuilder emailNotificationBuilder) {
    emailNotificationBuilder.withEmail(user.email());
    emailNotificationBuilder.withSubject("Email Notification Subject");
    emailNotificationBuilder.withContent("Email Notification Content");
    return emailNotificationBuilder.getEmailNotification();
  }

  public PushNotification buildPushNotificationContent(
      User user, PushNotificationBuilder pushNotificationBuilder) {
    pushNotificationBuilder.withDeviceId(user.deviceId());
    pushNotificationBuilder.withSubject("Push Notification Subject");
    pushNotificationBuilder.withContent("Push Notification Content");
    return pushNotificationBuilder.getPushNotification();
  }
}
