package org.fahim.designpattern.factory;

import org.springframework.stereotype.Service;

@Service
public class NotificationFactory {

  private final EmailNotification emailNotification;
  private final SmsNotification smsNotification;

  public NotificationFactory(EmailNotification emailNotification, SmsNotification smsNotification) {
    this.emailNotification = emailNotification;
    this.smsNotification = smsNotification;
  }

  public Notification createNotification(NotificationType type) {
    return switch (type) {
      case EMAIL -> emailNotification;
      case SMS -> smsNotification;
    };
  }
}
