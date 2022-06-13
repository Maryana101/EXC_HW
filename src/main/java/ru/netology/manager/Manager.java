package ru.netology.manager;

import ru.netology.repository.Repository;

public class Manager {
  private Repository repo = new Repository();
  
  public Manager(Repository repo) {
    this.repo = repo;
  }
  
  
  public void add(Product newProduct) {
    repo.save(newProduct);
  }
  
  public void removeProduct(int id) {
    repo.removeById(id);
  }
  
  public void setProducts(Product[] products) {
    repo.setProducts(products);
  }
  
  public Product[] getAllProducts() {
    return repo.getProducts();
  }
  
  public static boolean matches(Product product, String search) {
    return product.getName().contains(search);
  }
  
  public Product[] searchBy(String text) {
    Product[] result = new Product[0];
    
    for (Product product : getAllProducts()) {
      if (matches(product, text)) {
        Product[] tmp = new Product[result.length + 1];
        for (int i = 0; i < result.length; i++) {
          tmp[i] = result[i];
        }
        tmp[tmp.length - 1] = product;
        result = tmp;
      }
    }
    return result;
  }
}
