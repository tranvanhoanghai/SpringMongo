package com.app.springmongo.repository;

import com.app.springmongo.entity.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends MongoRepository<Test, String> {
}
