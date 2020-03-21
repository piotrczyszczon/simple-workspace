package com.github.piotrczyszczon.simpleworkset.rmiapplication.printer;

import java.rmi.RemoteException;

public class ConsoleMessagePrinter implements MessagePrinter
{
  private static final String STATUS_OK = "Message Received!";

  public String printMessage(String message) throws RemoteException
  {
    System.out.println("Received Message: " + message);

    return STATUS_OK;
  }
}
