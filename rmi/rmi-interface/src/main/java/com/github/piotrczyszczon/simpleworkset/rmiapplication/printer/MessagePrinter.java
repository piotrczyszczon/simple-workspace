package com.github.piotrczyszczon.simpleworkset.rmiapplication.printer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessagePrinter extends Remote
{
  String printMessage(String message) throws RemoteException;
}
