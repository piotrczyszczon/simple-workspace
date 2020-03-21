package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import javax.ejb.Stateful;

@Stateful(name = "CounterBean")
public class CounterBean implements CounterRemote
{
  private int counterState = 0;

  @Override
  public int incrementCounter()
  {
    return counterState++;
  }
}
