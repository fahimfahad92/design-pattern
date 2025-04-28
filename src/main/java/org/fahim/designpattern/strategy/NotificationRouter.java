package org.fahim.designpattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationRouter {

  private final EmailNotificationService emailNotificationService;
  private final PushNotificationService pushNotificationService;
  private final InAppNotificationService inAppNotificationService;

  @Autowired
  public NotificationRouter(
      EmailNotificationService emailNotificationService,
      PushNotificationService pushNotificationService,
      InAppNotificationService inAppNotificationService) {
    this.emailNotificationService = emailNotificationService;
    this.pushNotificationService = pushNotificationService;
    this.inAppNotificationService = inAppNotificationService;
  }

  /**
   * Sends a notification based on the specified {@code NotificationType}.
   * Delegates the notification process to the appropriate strategy,
   * such as email, push, or in-app notification.
   *
   * @param notificationType the type of notification to be sent; must be one of the values from {@code NotificationType}
   * @return the {@code NotificationType} that was successfully sent
   */
  public NotificationType sendNotification(NotificationType notificationType) {
    NotificationStrategy notificationStrategy = getNotificationStrategy(notificationType);
    NotificationContext notificationContext = new NotificationContext(notificationStrategy);
    return notificationContext.sendNotification();
  }

  private NotificationStrategy getNotificationStrategy(NotificationType notificationType) {
    return switch (notificationType) {
      case EMAIL -> emailNotificationService;
      case PUSH -> pushNotificationService;
      case IN_APP -> inAppNotificationService;
    };
  }
}
