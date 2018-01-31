package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> list(int cid);

    void add(Product product);

    void delete(int id);

    void update(Product product);

    Product get(int id);

    void setFirstProductImage(Product p);

    void fill(List<Category> cs);

    void fill(Category category);

    void fillByRow(List<Category> cs);

    void setSaleAndReviewNumber(Product product);

    void setSaleAndReviewNumber(List<Product> ps);

    List<Product> search(String keyword);
}
