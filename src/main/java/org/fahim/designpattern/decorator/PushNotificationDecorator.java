package org.fahim.designpattern.decorator;

public class PushNotificationDecorator extends NotificationDecorator {

  public PushNotificationDecorator(Notifier notifier) {
    super(notifier);
  }

  @Override
  public String sendNotification(String message, String to) {
    message = super.sendNotification(message, to);
    System.out.println("Push sent to " + to);
    if (message == null || message.isEmpty()) {
      return "Push";
    }
    return message + " , Push";
  }
}
