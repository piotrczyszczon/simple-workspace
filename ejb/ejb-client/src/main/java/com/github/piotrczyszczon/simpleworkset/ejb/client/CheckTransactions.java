package com.github.piotrczyszczon.simpleworkset.ejb.client;

import com.github.piotrczyszczon.simpleworkset.ejb.remote.transaction.ItemRemote;

import javax.naming.NamingException;

public class CheckTransactions
{
  public void execute() throws NamingException
  {
    ItemRemote itemRemote = EJBFactory.lookupItemBean();

    itemRemote.addItemAndRollback("Super Interesting Book", 99);
  }
}
