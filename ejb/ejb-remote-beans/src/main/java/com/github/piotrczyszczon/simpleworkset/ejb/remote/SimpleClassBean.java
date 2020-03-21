package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import javax.ejb.Stateless;

@Stateless(name = "SimpleClassBean")
public class SimpleClassBean implements SimpleClassRemote
{
  @Override
  public void doSomething()
  {
    System.out.println("SimpleClassBean is executed!");
  }
}
