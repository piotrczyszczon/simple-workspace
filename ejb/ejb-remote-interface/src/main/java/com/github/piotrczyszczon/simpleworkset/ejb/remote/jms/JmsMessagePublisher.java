package com.github.piotrczyszczon.simpleworkset.ejb.remote.jms;

import javax.ejb.Remote;

@Remote
public interface JmsMessagePublisher
{
  void askBeanToSendMessage(String topicName, String message);
}
