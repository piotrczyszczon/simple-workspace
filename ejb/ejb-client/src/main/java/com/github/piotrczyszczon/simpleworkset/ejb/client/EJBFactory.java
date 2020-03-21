package com.github.piotrczyszczon.simpleworkset.ejb.client;

import com.github.piotrczyszczon.simpleworkset.ejb.remote.*;
import com.github.piotrczyszczon.simpleworkset.ejb.remote.jms.JmsMessagePublisher;
import com.github.piotrczyszczon.simpleworkset.ejb.remote.transaction.ItemRemote;

import javax.naming.Context;
import javax.naming.NamingException;

import static com.github.piotrczyszczon.simpleworkset.ejb.client.context.InitialContextProvider.createInitialContext;

public class EJBFactory
{
  public static TextToUpperRemote lookupTextToUpperBean() throws NamingException
  {
    return (TextToUpperRemote) lookup("TextProcessorBean!com.github.piotrczyszczon.simpleworkset.ejb.remote.TextToUpperRemote");
  }

  public static TextToLowerRemote lookupTextToLowerBean() throws NamingException
  {
    return (TextToLowerRemote) lookup("TextProcessorBean!com.github.piotrczyszczon.simpleworkset.ejb.remote.TextToLowerRemote");
  }

  public static CounterRemote lookupCounterBean() throws NamingException
  {
    return (CounterRemote) lookup("CounterBean!com.github.piotrczyszczon.simpleworkset.ejb.remote.CounterRemote!stateful");
  }

  public static ListAppendingRemote lookupListAppendingBean() throws NamingException
  {
    return (ListAppendingRemote) lookup("ListAppendingBean!com.github.piotrczyszczon.simpleworkset.ejb.remote.ListAppendingRemote");
  }

  public static JmsMessagePublisher lookupJmsPublisherBean() throws NamingException
  {
    return (JmsMessagePublisher) lookup("JmsPublisherBean!com.github.piotrczyszczon.simpleworkset.ejb.remote.jms.JmsMessagePublisher");
  }

  public static ContainerBeanReturningAnotherBeanRemote lookupContainerBeanReturningAnotherBean() throws NamingException
  {
    return (ContainerBeanReturningAnotherBeanRemote) lookup("ContainerBeanReturningAnotherBean!com.github.piotrczyszczon.simpleworkset.ejb.remote.ContainerBeanReturningAnotherBeanRemote");
  }

  public static SpecialStatesStatelessRemote lookupSpecialStatesStatelessBean() throws NamingException
  {
    return (SpecialStatesStatelessRemote) lookup("SpecialStatesStatelessBean!com.github.piotrczyszczon.simpleworkset.ejb.remote.SpecialStatesStatelessRemote");
  }

  public static SpecialStatesStatefulRemote lookupSpecialStatesStatefulBean() throws NamingException
  {
    return (SpecialStatesStatefulRemote) lookup("SpecialStatesStatefulBean!com.github.piotrczyszczon.simpleworkset.ejb.remote.SpecialStatesStatefulRemote!stateful");
  }

  public static ItemRemote lookupItemBean() throws NamingException
  {
    return (ItemRemote) lookup("ItemBean!com.github.piotrczyszczon.simpleworkset.ejb.remote.transaction.ItemRemote?stateful");
  }

  public static Object lookup(String beanName) throws NamingException
  {
    Context ctx = createInitialContext();

    return ctx.lookup(jndiName(beanName));
  }

  public static String jndiName(String beanName)
  {
    return "ejb:/remote-beans//" + beanName;
  }
}
