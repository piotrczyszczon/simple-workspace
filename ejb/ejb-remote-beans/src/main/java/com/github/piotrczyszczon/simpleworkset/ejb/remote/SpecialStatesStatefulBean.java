package com.github.piotrczyszczon.simpleworkset.ejb.remote;

import com.github.piotrczyszczon.simpleworkset.ejb.remote.state.NotSerializableObject;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(SpecialStatesStatefulRemote.class)
public class SpecialStatesStatefulBean implements SpecialStatesStatefulRemote
{
  private String serializableState = "SerializableState";
  private NotSerializableObject notSerializableObject = new NotSerializableObject();

  @PostConstruct
  public void postConstruct()
  {
    System.out.println("Stateful bean has been CONSTRUCTED");
  }

  @PreDestroy
  public void preDestroy()
  {
    System.out.println("Stateful bean is going to be DESTROYED!");
  }

  @Override
  public void execute()
  {
    System.out.println("Stateful bean EXECUTED!");
    System.out.println("serializableState: " + serializableState);
    System.out.println("Not SerializableObject" + notSerializableObject);
  }

  @PrePassivate
  public void prePassivate()
  {
    System.out.println("Stateful bean is going to be PASSIVATED!");
  }

  @PostActivate
  public void postActivate()
  {
    System.out.println("Stateful bean has been ACTIVATED!");
  }
}
