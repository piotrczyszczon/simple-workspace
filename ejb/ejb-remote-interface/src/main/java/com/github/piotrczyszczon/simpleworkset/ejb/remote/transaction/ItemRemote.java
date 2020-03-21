package com.github.piotrczyszczon.simpleworkset.ejb.remote.transaction;

public interface ItemRemote
{
  void addItemAndRollback(String itemName, int price);
}
