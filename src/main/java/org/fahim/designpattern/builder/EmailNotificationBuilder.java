package org.fahim.designpattern.builder;

import org.springframework.util.StringUtils;

public class EmailNotificationBuilder {

  String subject;
  String content;
  String email;

  public EmailNotificationBuilder() {}

  public void withSubject(String subject) {
    this.subject = subject;
  }

  public void withContent(String content) {
    this.content = content;
  }

  public void withEmail(String email) {
    this.email = email;
  }

  public EmailNotification getEmailNotification() {
    if (StringUtils.isEmpty(email)) {
      throw new IllegalArgumentException("Email is required");
    }

    if (StringUtils.isEmpty(subject) && StringUtils.isEmpty(content)) {
      throw new IllegalArgumentException("Subject or content is required");
    }
    return new EmailNotification(subject, content, email);
  }
}
