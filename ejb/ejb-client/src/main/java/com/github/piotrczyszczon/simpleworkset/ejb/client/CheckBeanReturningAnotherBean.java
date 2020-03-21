package com.github.piotrczyszczon.simpleworkset.ejb.client;

import javax.naming.NamingException;

import static com.github.piotrczyszczon.simpleworkset.ejb.client.EJBFactory.lookupContainerBeanReturningAnotherBean;

public class CheckBeanReturningAnotherBean
{
  public void execute() throws NamingException
  {
    lookupContainerBeanReturningAnotherBean().getOtherBeanFromContainer().doSomething();
  }
}
