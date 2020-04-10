package com.github.piotrczyszczon.simpleworkspace.modularity.library.impl;

import com.github.piotrczyszczon.simpleworkspace.modularity.library.*;
import java.util.*;

public class OfficeImpl implements Office
{
  private List<String> books = new ArrayList<>();

  public void addBook(String bookName)
  {
    System.out.println("Adding book: " + bookName);
    books.add(bookName);
  }

  public void removeBook(int id)
  {
    System.out.println("Removing book id: " + id);
    books.remove(id);
  }

  public List<String> listBooks()
  {
    return books;
  }
}