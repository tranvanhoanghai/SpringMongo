package com.app.springmongo.repository;


import com.app.springmongo.entity.TableConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TableConfigRepo extends MongoRepository<TableConfig, String> {
    TableConfig findByTableId(String TableId);
}
