package com.github.piotrczyszczon.simpleworkset.ejb.remote.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {@ActivationConfigProperty(propertyName = "destination", propertyValue = "superTopicForTests"), @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")})
public class MessageConsumer implements MessageListener
{
  @Override
  public void onMessage(Message message)
  {
    TextMessage textMessage = (TextMessage) message;

    try
    {
      System.out.println("Message Received: " + textMessage.getText());
    } catch (JMSException e)
    {
      System.out.println("Error While trying to conume messages: " + e.getMessage());
    }
  }
}
