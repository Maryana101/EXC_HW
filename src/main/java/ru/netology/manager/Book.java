package ru.netology.manager;

public class Book extends Product {
  private String author;
  
  
  public Book(int id, String name, long cost, String author) {
    super(id, name, cost);
    this.author = author;
  }
  
  
}
