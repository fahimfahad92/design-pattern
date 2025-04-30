package org.fahim.designpattern.builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NotificationBuilderServiceTest {

  @Autowired NotificationContentService notificationContentService;

  private static User user;

  @BeforeAll
  public static void setUp() {
    user = getTestUser();
  }

  @Test
  void shouldReturnEmailNotification() {
    EmailNotification emailNotification = notificationContentService.buildEmailNotification(user);
    assertEquals("Email Notification Subject", emailNotification.subject());
    assertEquals("Email Notification Content", emailNotification.content());
    assertEquals(user.email(), emailNotification.email());
  }

  @Test
  void shouldReturnPushNotification() {
    PushNotification pushNotification = notificationContentService.buildPushNotification(user);
    assertEquals("Push Notification Subject", pushNotification.subject());
    assertEquals("Push Notification Content", pushNotification.content());
    assertEquals(user.deviceId(), pushNotification.deviceId());
  }

  private static User getTestUser() {
    return new User("Fahim", "fahim@gmail.com", "123456789");
  }
}
