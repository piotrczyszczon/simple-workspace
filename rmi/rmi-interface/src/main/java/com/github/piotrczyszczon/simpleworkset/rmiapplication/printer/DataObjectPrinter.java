package com.github.piotrczyszczon.simpleworkset.rmiapplication.printer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataObjectPrinter extends Remote
{
  void print(BooksCount booksCount) throws RemoteException;
}
