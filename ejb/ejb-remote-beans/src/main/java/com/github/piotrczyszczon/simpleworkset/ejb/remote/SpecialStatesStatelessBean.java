package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(SpecialStatesStatelessRemote.class)
public class SpecialStatesStatelessBean implements SpecialStatesStatelessRemote
{
  @PostConstruct
  public void postConstruct()
  {
    System.out.println("Stateless bean has been CONSTRUCTED");
  }

  @PreDestroy
  public void preDestroy()
  {
    System.out.println("Stateless bean is going to be DESTROYED!");
  }

  @Override
  public void execute()
  {
    System.out.println("Special State [Stateless] bean executing!");
  }
}
