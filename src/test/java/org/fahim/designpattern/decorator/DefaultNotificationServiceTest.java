package org.fahim.designpattern.decorator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DefaultNotificationServiceTest {

  @Autowired NotificationService notificationService;

  @ParameterizedTest
  @MethodSource("notificationDecoratorTestData")
  void shouldReturnProperNotifications(
      NotificationSettings notificationSettings, String expectedResponse) {
    String res = notificationService.sendNotification("Fahim", notificationSettings);
    assertEquals(expectedResponse, res);
  }

  private static Stream<Arguments> notificationDecoratorTestData() {
    return Stream.of(
        Arguments.of(new NotificationSettings(true, false, false), "Email"),
        Arguments.of(new NotificationSettings(true, true, false), "Email , Push"),
        Arguments.of(new NotificationSettings(true, true, true), "Email , Push , InApp"));
  }
}
