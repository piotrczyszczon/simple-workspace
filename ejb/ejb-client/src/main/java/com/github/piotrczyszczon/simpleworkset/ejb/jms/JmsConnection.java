package com.github.piotrczyszczon.simpleworkset.ejb.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.NamingException;

public class JmsConnection
{
  public static Connection createJmsConnection(Context initialContext) throws NamingException, JMSException
  {
    ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("jms/RemoteConnectionFactory");

    return connectionFactory.createConnection("jms-user", "jms-user");
  }
}
