package com.github.piotrczyszczon.simpleworkset.ejb.remote.transaction;

import com.github.piotrczyszczon.simpleworkset.ejb.remote.transaction.dao.ItemsTable;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.rmi.RemoteException;

//@Stateful(name = "ItemBean")
//@Remote(ItemRemote.class)
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class ItemBean implements ItemRemote, SessionSynchronization
{
  //@Resource
  private SessionContext sessionContext;

  //@PersistenceContext(unitName = "configuration")
  private EntityManager entityManager;

  @Override
  @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
  public void addItemAndRollback(String itemName, int price)
  {
    ItemsTable itemsTable = new ItemsTable(itemName, price);

    entityManager.persist(itemName);

    sessionContext.setRollbackOnly();
  }

  @Override
  public void afterBegin() throws EJBException, RemoteException
  {
    System.out.println("afterBegin");
  }

  @Override
  public void beforeCompletion() throws EJBException, RemoteException
  {
    System.out.println("beforeCompletion");
  }

  @Override
  public void afterCompletion(boolean b) throws EJBException, RemoteException
  {
    System.out.println("afterCompletion");
  }
}
