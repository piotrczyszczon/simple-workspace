package com.github.piotrczyszczon.simpleworkset.ejb.client;

import com.github.piotrczyszczon.simpleworkset.ejb.remote.SpecialStatesStatefulRemote;

import javax.naming.NamingException;
import java.util.stream.IntStream;

public class CheckSpecialBeanStates
{
  public void execute() throws NamingException
  {
    checkStatefulBean();
    checkStatelessBean();
  }

  private void checkStatefulBean() throws NamingException
  {
    SpecialStatesStatefulRemote specialStatesStatefulRemote = EJBFactory.lookupSpecialStatesStatefulBean();
    specialStatesStatefulRemote.execute();
    specialStatesStatefulRemote.execute();
  }

  private void checkStatelessBean()
  {
    IntStream.range(0, 100).parallel().forEach(CheckSpecialBeanStates::spamStatelessBean);
  }

  private static void spamStatelessBean(int someId)
  {
    for (int i = 0; i < 10; ++i)
    {
      try
      {
        EJBFactory.lookupSpecialStatesStatelessBean().execute();
      } catch (NamingException e)
      {
        e.printStackTrace();
      }
    }
  }
}
