package com.github.piotrczyszczon.simpleworkset.ejb.remote.transaction.dao;

import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
public class ItemsTable
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
  @SequenceGenerator(name = "id_generator", sequenceName = "ITEMS_SEQUENCE")
  private int id;
  @Column
  private String name;
  @Column
  private int price;

  public ItemsTable(String name, int price)
  {
    this.name = name;
    this.price = price;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getPrice()
  {
    return price;
  }

  public void setPrice(int price)
  {
    this.price = price;
  }
}
