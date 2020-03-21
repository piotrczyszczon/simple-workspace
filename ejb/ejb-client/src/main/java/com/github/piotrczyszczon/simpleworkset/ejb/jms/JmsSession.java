package com.github.piotrczyszczon.simpleworkset.ejb.jms;

import javax.jms.*;
import javax.naming.Context;

public class JmsSession
{
  private Context initialContext;
  private Session session;

  public JmsSession(Context initialContext, Session session)
  {
    this.initialContext = initialContext;
    this.session = session;
  }

  public MessageConsumer createConsumer(Topic topic) throws JMSException
  {
    return session.createConsumer(topic);
  }

  public MessageProducer createProducer(Topic topic) throws JMSException
  {
    return session.createProducer(topic);
  }

  public Session getSession()
  {
    return session;
  }

  public static JmsSession jmsSession(Context initialContext, Connection connection) throws JMSException
  {
    return new JmsSession(initialContext, connection.createSession(false, Session.AUTO_ACKNOWLEDGE));
  }
}
