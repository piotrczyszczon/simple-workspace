package com.github.piotrczyszczon.simpleworkset.rmiapplication.printer;

import java.rmi.RemoteException;

public class SilentPrinter implements MessagePrinter
{
  public String printMessage(String message) throws RemoteException
  {
    System.out.println("I'm do not print any message!");

    return "Message Received By Silent Printer";
  }
}
