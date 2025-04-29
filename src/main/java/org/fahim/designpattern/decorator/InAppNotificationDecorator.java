package org.fahim.designpattern.decorator;

public class InAppNotificationDecorator extends NotificationDecorator {
  public InAppNotificationDecorator(Notifier notifier) {
    super(notifier);
  }

  @Override
  public String sendNotification(String message, String to) {
    message = super.sendNotification(message, to);
    System.out.println("InApp sent to " + to);
    if (message == null || message.isEmpty()) {
      return "InApp";
    }
    return message + " , InApp";
  }
}
