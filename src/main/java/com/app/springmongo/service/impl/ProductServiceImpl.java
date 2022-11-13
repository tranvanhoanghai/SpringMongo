package com.app.springmongo.service.impl;

import com.app.springmongo.entity.Product;
import com.app.springmongo.repository.ProductRepo;
import com.app.springmongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getById(String productId) {
        return productRepo.findById(productId);
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }
}
