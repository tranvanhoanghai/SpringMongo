package com.app.springmongo.repository;

import com.app.springmongo.entity.ProductType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepo extends MongoRepository<ProductType, String> {
}
