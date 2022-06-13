package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.*;
import ru.netology.repository.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerExceptionsTest {
  Product book1 = new Book(1, "Кот в шляпе", 62, "Доктор Сьюз");
  Product book2 = new Book(2, "Кот в сапогах", 40, "Шарль Перро");
  Product telephone1 = new Smartphone(3, "Nokia", 120, "Финляндия");
  Product telephone2 = new Smartphone(4, "Sony", 140, "Япония");
  Product book3 = new Book(5, "Уход за домашними кошками", 35, "Катерина Кошкина");
  
  Repository repo = new Repository();
  Manager manager = new Manager(repo);
  
  @Test
  public void shouldRemoveProductFromRepo() {
    Product[] products = {book1, book2, telephone1};
    manager.setProducts(products);
    manager.removeProduct(3);
    
    Product[] actual = manager.getAllProducts();
    Product[] expected = {book1, book2};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void shouldThrowExceptionThenTryRemoveNotExistingProduct() {
    Product[] products = {telephone1, telephone2};
    manager.setProducts(products);
    
    assertThrows(NotFoundException.class, () -> {
      repo.removeById(1);
    });
  }
  
  @Test
  public void shouldAddNewProductInRepo() {
    Product[] products = {book1, book2};
    manager.setProducts(products);
    manager.add(book3);
    
    Product[] actual = manager.getAllProducts();
    Product[] excpected = {book1, book2, book3};
    assertArrayEquals(actual, excpected);
  }
  
  @Test
  public void shouldThrowExceptionThenAddProduct() {
    Product[] products = {book1, book2};
    manager.setProducts(products);
    
    assertThrows(AlreadyExistsException.class, () -> {
      manager.add(book2);
    });
  }
}
