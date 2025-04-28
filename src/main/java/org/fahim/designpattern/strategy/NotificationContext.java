package org.fahim.designpattern.strategy;

public class NotificationContext {
    private final NotificationStrategy strategy;

    public NotificationContext(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public NotificationType sendNotification() {
        return strategy.sendNotification();
    }
}
