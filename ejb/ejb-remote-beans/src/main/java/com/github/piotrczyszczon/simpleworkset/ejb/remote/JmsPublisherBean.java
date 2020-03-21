package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import com.github.piotrczyszczon.simpleworkset.ejb.remote.jms.JmsMessagePublisher;

import javax.ejb.Stateless;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless(name = "JmsPublisherBean")
public class JmsPublisherBean implements JmsMessagePublisher
{
  @Override
  public void askBeanToSendMessage(String topicName, String message)
  {
    try
    {
      sendMessage(topicName, message);
    } catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }

  private void sendMessage(String topicName, String message) throws NamingException, JMSException
  {
    Context initialContext = new InitialContext();

    ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("/ConnectionFactory");
    Topic topic = (Topic) initialContext.lookup(topicName);

    try (Connection connection = connectionFactory.createConnection())
    {
      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

      MessageProducer publisher = session.createProducer(topic);

      connection.start();

      TextMessage textMessage = session.createTextMessage(message);

      publisher.send(textMessage);
    }
  }
}
