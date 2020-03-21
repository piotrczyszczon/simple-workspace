package com.github.piotrczyszczon.simpleworkset.ejb.client;

import com.github.piotrczyszczon.simpleworkset.ejb.remote.CounterRemote;
import com.github.piotrczyszczon.simpleworkset.ejb.remote.TextToLowerRemote;
import com.github.piotrczyszczon.simpleworkset.ejb.remote.TextToUpperRemote;

import javax.naming.NamingException;

public class CheckSimpleCalls
{
  public void execute() throws NamingException
  {
    TextToUpperRemote textToUpper = EJBFactory.lookupTextToUpperBean();
    TextToLowerRemote textToLower = EJBFactory.lookupTextToLowerBean();
    CounterRemote counter = EJBFactory.lookupCounterBean();
    CounterRemote counter2 = EJBFactory.lookupCounterBean();

    System.out.println(textToLower.convertTextToLower("sAmPlE TeXt"));
    System.out.println(textToUpper.convertTextToUpper("sAmPlE TeXt"));
    System.out.println(counter.incrementCounter());
    System.out.println(counter.incrementCounter());
    System.out.println(counter.incrementCounter());
    System.out.println(counter.incrementCounter());
    System.out.println(counter2.incrementCounter());
    System.out.println(counter2.incrementCounter());
    System.out.println(counter.incrementCounter());
  }
}
