package org.fahim.designpattern.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotificationRouterTest {

  @Autowired NotificationRouter notificationRouter;

  @ParameterizedTest
  @MethodSource("notificationRouterTestData")
  void shouldReturnProperNotificationType(NotificationType notificationType) {
    assertEquals(notificationType, notificationRouter.sendNotification(notificationType));
  }

  private static Stream<Arguments> notificationRouterTestData() {
    return Stream.of(
        Arguments.of(NotificationType.EMAIL),
        Arguments.of(NotificationType.PUSH),
        Arguments.of(NotificationType.IN_APP));
  }
}
