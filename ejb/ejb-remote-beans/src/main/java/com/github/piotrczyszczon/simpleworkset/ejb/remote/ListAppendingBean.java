package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import javax.ejb.Stateless;
import java.util.concurrent.BlockingQueue;

@Stateless(name = "ListAppendingBean")
public class ListAppendingBean implements ListAppendingRemote
{
  @Override
  public void appendNextValue(BlockingQueue<String> someList)
  {
    try
    {
      System.out.println("ListAppendingBean: Adding Value");
      someList.put("SomeValue");
    } catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
