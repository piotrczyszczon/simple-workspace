package com.github.piotrczyszczon.simpleworkset.rmiapplication;

import com.github.piotrczyszczon.simpleworkset.rmiapplication.printer.BooksCount;
import com.github.piotrczyszczon.simpleworkset.rmiapplication.printer.DataObjectPrinter;
import com.github.piotrczyszczon.simpleworkset.rmiapplication.printer.MessagePrinter;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientApplication
{
  public static void main(String[] args) throws RemoteException, NotBoundException
  {
    new ClientApplication().execute();
  }

  private void execute() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry(1100);

    checkMessagePrinter(registry);
    checkSilentPrinter(registry);
    checkDataObjectPrinter(registry);
  }

  private void checkMessagePrinter(Registry registry) throws RemoteException, NotBoundException
  {
    MessagePrinter messagePrinter = (MessagePrinter) registry.lookup("messagePrinter");
    String status = messagePrinter.printMessage("Message from Client!");
    System.out.println("Message Status: " + status);
  }

  private void checkSilentPrinter(Registry registry) throws RemoteException, NotBoundException
  {
    MessagePrinter messagePrinter = (MessagePrinter) registry.lookup("silentPrinter");
    String status = messagePrinter.printMessage("Message from Client!");
    System.out.println("Message Status: " + status);
  }

  private void checkDataObjectPrinter(Registry registry) throws RemoteException, NotBoundException
  {
    DataObjectPrinter dataObjectPrinter = (DataObjectPrinter) registry.lookup("dataObjectPrinter");
    dataObjectPrinter.print(new BooksCount("Harry Potter", 8_000_000));
  }
}
