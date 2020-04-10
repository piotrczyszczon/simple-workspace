package com.github.piotrczyszczon.simpleworkspace.modularity.library.client;

import com.github.piotrczyszczon.simpleworkspace.modularity.library.*;
import java.util.*;

public class OfficeClient
{
  public static void main(String[] args)
  {
    ServiceLoader<Office> offices = ServiceLoader.load(Office.class);
    for (Office office : offices)
    {
      office.addBook("Harry Potter");
      office.addBook("Tyrany of Status Quo");
      System.out.println(office.listBooks());
    }
  }
}