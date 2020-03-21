package com.github.piotrczyszczon.simpleworkset.ejb.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.NamingException;

import static com.github.piotrczyszczon.simpleworkset.ejb.jms.JmsConnection.createJmsConnection;

public class ClientMessageConsumer
{
  private final Context initialContext;

  public ClientMessageConsumer(Context initialContext)
  {
    this.initialContext = initialContext;
  }

  public void receiveMessage(String topicName) throws NamingException, JMSException
  {
    try (Connection connection = createJmsConnection(initialContext))
    {
      JmsSession jmsSession = JmsSession.jmsSession(initialContext, connection);

      MessageConsumer consumer = jmsSession.createConsumer(JmsTopic.jmsTopic(initialContext, topicName));

      connection.start();

      TextMessage receivedMessage = (TextMessage) consumer.receive();

      System.out.println("Client Received Message: " + receivedMessage.getText());
    }
  }

  public static ClientMessageConsumer messageConsumer(Context initialContext)
  {
    return new ClientMessageConsumer(initialContext);
  }
}
