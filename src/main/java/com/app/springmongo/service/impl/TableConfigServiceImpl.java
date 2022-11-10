package com.app.springmongo.service.impl;

import com.app.springmongo.entity.TableConfig;
import com.app.springmongo.repository.TableConfigRepo;
import com.app.springmongo.service.TableConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableConfigServiceImpl implements TableConfigService {

    @Autowired
    private TableConfigRepo tableConfigRepo;

    @Override
    public List<TableConfig> getAllTableConfig() {
        return tableConfigRepo.findAll();
    }

    @Override
    public TableConfig getTableConfigById(String tableId) {
        return tableConfigRepo.findByTableId(tableId);
    }

    @Override
    public TableConfig saveTableConfig(TableConfig tableConfig) {
        return tableConfigRepo.save(tableConfig);
    }
}
