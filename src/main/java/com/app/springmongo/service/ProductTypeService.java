package com.app.springmongo.service;

import com.app.springmongo.entity.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductTypeService {
    List<ProductType> getAll();

    Optional<ProductType> getById(String productTypeId);

    ProductType save(ProductType productType);
}
