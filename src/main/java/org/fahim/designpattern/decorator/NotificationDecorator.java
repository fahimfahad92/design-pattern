package org.fahim.designpattern.decorator;

public abstract class NotificationDecorator implements Notifier {

  private final Notifier notifier;

  public NotificationDecorator(Notifier notifier) {
    this.notifier = notifier;
  }

  @Override
  public String sendNotification(String message, String to) {
    return notifier.sendNotification(message, to);
  }
}
