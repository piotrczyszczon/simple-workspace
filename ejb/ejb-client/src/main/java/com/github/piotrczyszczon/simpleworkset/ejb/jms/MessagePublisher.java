package com.github.piotrczyszczon.simpleworkset.ejb.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.NamingException;

public class MessagePublisher
{
  private final Context initialContext;

  public MessagePublisher(Context initialContext)
  {
    this.initialContext = initialContext;
  }

  public void publishMessage(String messageContent) throws JMSException, NamingException
  {
    try (Connection connection = JmsConnection.createJmsConnection(initialContext))
    {
      JmsSession jmsSession = JmsSession.jmsSession(initialContext, connection);

      MessageProducer publisher = jmsSession.createProducer(JmsTopic.jmsTopic(initialContext, "jms/topic/superTopicForTests"));

      connection.start();

      TextMessage textMessage = jmsSession.getSession().createTextMessage(messageContent);

      publisher.send(textMessage);
    }
  }

  public static MessagePublisher messagePublisher(Context initialContext)
  {
    return new MessagePublisher(initialContext);
  }
}
