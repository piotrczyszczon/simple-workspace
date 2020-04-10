package com.github.piotrczyszczon.simpleworkspace.modularity.library;

import java.util.*;

public interface Office
{
  void addBook(String bookName);

  void removeBook(int id);

  List<String> listBooks();
}