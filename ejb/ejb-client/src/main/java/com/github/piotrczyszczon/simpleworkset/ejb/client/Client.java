package com.github.piotrczyszczon.simpleworkset.ejb.client;

import javax.jms.JMSException;
import javax.naming.NamingException;

public class Client
{
  public static void main(String[] args) throws NamingException, JMSException
  {
    //new CheckBeanReturningAnotherBean().execute();
    //new CheckJms().execute();
    new CheckSimpleCalls().execute();
    //new CheckSpecialBeanStates().execute();
    //new CheckTransactions().execute();
  }
}
