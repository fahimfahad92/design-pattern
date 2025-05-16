package org.fahim.designpattern.factory;

import org.springframework.stereotype.Service;

@Service
public class SmsNotification implements Notification {

  @Override
  public String sendNotification(User user) {
    return "Sending sms notification to " + user.phoneNumber();
  }
}
