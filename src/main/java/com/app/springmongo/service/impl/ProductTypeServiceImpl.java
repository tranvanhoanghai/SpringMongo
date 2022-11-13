package com.app.springmongo.service.impl;

import com.app.springmongo.entity.ProductType;
import com.app.springmongo.repository.ProductTypeRepo;
import com.app.springmongo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepo productTypeRepo;


    @Override
    public List<ProductType> getAll() {
        return productTypeRepo.findAll();
    }

    @Override
    public Optional<ProductType> getById(String productTypeId) {
        return productTypeRepo.findById(productTypeId);
    }

    @Override
    public ProductType save(ProductType productType) {
        return productTypeRepo.save(productType);
    }
}
