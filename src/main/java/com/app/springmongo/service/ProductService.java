package com.app.springmongo.service;

import com.app.springmongo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();

    Optional<Product> getById(String productId);

    Product save(Product product);
}
