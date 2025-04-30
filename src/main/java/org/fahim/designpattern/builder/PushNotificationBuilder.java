package org.fahim.designpattern.builder;

import org.springframework.util.StringUtils;

public class PushNotificationBuilder {

  String subject;
  String content;
  String deviceId;

  public PushNotificationBuilder() {}

  public void withSubject(String subject) {
    this.subject = subject;
  }

  public void withContent(String content) {
    this.content = content;
  }

  public void withDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public PushNotification getPushNotification() {
    if (StringUtils.isEmpty(deviceId)) {
      throw new IllegalArgumentException("Device id is required");
    }

    if (StringUtils.isEmpty(subject) && StringUtils.isEmpty(content)) {
      throw new IllegalArgumentException("Subject or content is required");
    }
    return new PushNotification(subject, content, deviceId);
  }
}
