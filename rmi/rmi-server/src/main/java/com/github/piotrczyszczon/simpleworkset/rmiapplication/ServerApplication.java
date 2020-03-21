package com.github.piotrczyszczon.simpleworkset.rmiapplication;

import com.github.piotrczyszczon.simpleworkset.rmiapplication.printer.ConsoleDataObjectPrinter;
import com.github.piotrczyszczon.simpleworkset.rmiapplication.printer.ConsoleMessagePrinter;
import com.github.piotrczyszczon.simpleworkset.rmiapplication.printer.MessagePrinter;
import com.github.piotrczyszczon.simpleworkset.rmiapplication.printer.SilentPrinter;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerApplication
{
  public static void main(String[] args) throws AlreadyBoundException, RemoteException
  {
    new ServerApplication().run();
  }

  public void run() throws RemoteException, AlreadyBoundException
  {
    LocateRegistry.createRegistry(1100);

    MessagePrinter stubPrinter = (MessagePrinter) deployObject("messagePrinter", new ConsoleMessagePrinter());
    stubPrinter.printMessage("Message From Server!");

    deployObject("silentPrinter", new SilentPrinter());
    deployObject("dataObjectPrinter", new ConsoleDataObjectPrinter());
  }

  public Remote deployObject(String name, Remote remote) throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.getRegistry(1100);

    Remote stubRemote = UnicastRemoteObject.exportObject(remote, 1201);

    registry.bind(name, stubRemote);

    return stubRemote;
  }
}
