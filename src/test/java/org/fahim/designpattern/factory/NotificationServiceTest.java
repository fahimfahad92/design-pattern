package org.fahim.designpattern.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotificationServiceTest {

  @Autowired private NotificationService notificationService;

  @ParameterizedTest
  @MethodSource("notificationServiceTestData")
  void shouldReturnProperNotificationType(
      User user, NotificationType notificationType, String response) {
    assertEquals(response, notificationService.sendNotification(user, notificationType));
  }

  private static Stream<Arguments> notificationServiceTestData() {
    return Stream.of(
        Arguments.of(
            new User("Test user 1", "test1@gmail.com", "1234567890"),
            NotificationType.EMAIL,
            "Sending email notification to test1@gmail.com"),
        Arguments.of(
            new User("Test user 2", "test2@gmail.com", "1234567891"),
            NotificationType.EMAIL,
            "Sending email notification to test2@gmail.com"),
        Arguments.of(
            new User("Test user 1", "test1@gmail.com", "1234567890"),
            NotificationType.SMS,
            "Sending sms notification to 1234567890"),
        Arguments.of(
            new User("Test user 2", "test2@gmail.com", "1234567891"),
            NotificationType.SMS,
            "Sending sms notification to 1234567891"));
  }
}
