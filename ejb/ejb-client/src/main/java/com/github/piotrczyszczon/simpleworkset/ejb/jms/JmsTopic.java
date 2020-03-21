package com.github.piotrczyszczon.simpleworkset.ejb.jms;

import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.NamingException;

public class JmsTopic
{
  public static Topic jmsTopic(Context initialContext, String topicName) throws NamingException
  {
    return (Topic) initialContext.lookup(topicName);
  }
}
