package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {
  private Product[] items = new Product[0];

  public void save(Product item) {
    int length = items.length + 1;
    Product[] tmp = new Product[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public Product[] findAll() {
    return items;
  }

  public Product[] findById(int id) {
    Product[] result = new Product[0];
    int index = 0;
    for (Product item : items) {
      if (item.getId() == id) {
        int length = result.length + 1;
        Product[] tmp = new Product[length];
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = items[index];
        result = tmp;
      }
      index++;
    }
    if (result.length == 0) {
      return null;
    } else {
      return result;
    }
  }

  public void removeById(int id) {
    Product[] removingItem = findById(id);
    if (removingItem == null) {
      throw new NotFoundException("Element with id " + id + " not found");
    }
    List<Product> list = new ArrayList<>(Arrays.asList(items));
    list.remove(removingItem[0]);
    Product[] result = new Product[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    items = result;
  }
}