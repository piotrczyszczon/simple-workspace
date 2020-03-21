package com.github.piotrczyszczon.simpleworkset.ejb.remote.state;

public class NotSerializableObject
{
  private String someState = "State of Not Serializable Object";

  public String getSomeState()
  {
    return someState;
  }

  @Override
  public String toString()
  {
    return "NotSerializableObject{" + "someState='" + someState + '\'' + '}';
  }
}
