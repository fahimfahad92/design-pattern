package org.fahim.designpattern.decorator;

public class EmailNotificationDecorator extends NotificationDecorator {
  private final EmailNotificationHandler emailNotificationHandler;

  public EmailNotificationDecorator(
      Notifier notifier, EmailNotificationHandler emailNotificationHandler) {
    super(notifier);
    this.emailNotificationHandler = emailNotificationHandler;
  }

  /**
   * Sends a notification by combining the functionality of the base notifier and the email
   * notification handler. It first delegates the message to the base notifier and then sends the
   * notification via email. EmailNotificationHandler is used to demonstrate the use of autowired
   * annotation if needed. We need to provide all the dependencies to the decorator class to work as
   * expected.
   *
   * @param message the content of the notification. Can be null or empty.
   * @param to the recipient of the notification.
   * @return a string representation of the notification result, which includes the modifications
   *     made by the email notification handler.
   */
  @Override
  public String sendNotification(String message, String to) {
    message = super.sendNotification(message, to);
    return emailNotificationHandler.sendNotification(message, to);
  }
}
