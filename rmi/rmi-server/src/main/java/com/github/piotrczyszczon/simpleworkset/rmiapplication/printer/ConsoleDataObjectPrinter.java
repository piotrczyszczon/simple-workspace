package com.github.piotrczyszczon.simpleworkset.rmiapplication.printer;

import java.rmi.RemoteException;

public class ConsoleDataObjectPrinter implements DataObjectPrinter
{
  public void print(BooksCount booksCount) throws RemoteException
  {
    System.out.println(booksCount);
  }
}
