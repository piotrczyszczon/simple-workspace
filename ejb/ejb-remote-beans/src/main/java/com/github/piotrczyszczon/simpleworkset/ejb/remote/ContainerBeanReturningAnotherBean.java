package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless(name = "ContainerBeanReturningAnotherBean")
public class ContainerBeanReturningAnotherBean implements ContainerBeanReturningAnotherBeanRemote
{
  @EJB
  private SimpleClassRemote simpleClassRemote;

  @Override
  public SimpleClassRemote getOtherBeanFromContainer()
  {
    //return simpleClassRemote;
    return manualLookup();
    //return new SimpleClassBean();
  }

  private SimpleClassRemote manualLookup()
  {
    try
    {
      return (SimpleClassRemote) new InitialContext().lookup("ejb:/remote-beans//SimpleClassBean!com.github.piotrczyszczon.simpleworkset.ejb.remote.SimpleClassRemote");
    } catch (NamingException e)
    {
      e.printStackTrace();
      return null;
    }
  }
}
