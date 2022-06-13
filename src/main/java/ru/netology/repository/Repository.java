package ru.netology.repository;

import ru.netology.manager.Product;

public class Repository {
  private Product[] products = new Product[0];
  
  public void save(Product newProduct) {
    Product[] tmp = new Product[products.length + 1];
    for (int i = 0; i < products.length; i++) {
      tmp[i] = products[i];
    }
    tmp[tmp.length - 1] = newProduct;
    products = tmp;
  }
  
  public Product[] getProducts() {
    return products;
  }
  
  public void setProducts(Product[] products) {
    this.products = products;
  }
  
  public Product findById(int id) {
    for (Product product : products) {
      if (product.getId() == id) {
        return product;
      }
    }
    return null;
  }
  
  public void removeById(int id) {
    
    if (findById(id) == null) {
      throw new NotFoundException("Товара с id = " + id + " нет в репозитории");
    }
    Product[] tmp = new Product[products.length - 1];
    int index = 0;
    for (int i = 0; i < products.length; i++) {
      if (products[i].getId() != id) {
        tmp[index] = products[i];
        index++;
      }
    }
    products = tmp;
  }
}
