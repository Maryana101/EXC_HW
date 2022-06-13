package ru.netology.manager;

public class Product {
  protected int id;
  protected String name;
  protected long cost;
  
  public Product(int id, String name, long cost) {
    this.id = id;
    this.name = name;
    this.cost = cost;
  }
  
  public int getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
}
