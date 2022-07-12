package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.Collection;

public interface ProductService {
    Product create(Product product);
    Collection<Product> list(int limit);
    Product get(Long id);
    Product getProductByProductId(String productId);
    Product update(Product product);
    Boolean delete(Long id);
    Boolean deleteByProductId(String productId);
}
