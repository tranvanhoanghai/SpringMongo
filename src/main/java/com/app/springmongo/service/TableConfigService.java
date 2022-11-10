package com.app.springmongo.service;

import com.app.springmongo.entity.TableConfig;
import java.util.List;

public interface TableConfigService {
    List<TableConfig> getAllTableConfig();

    TableConfig getTableConfigById(String tableId);

    TableConfig saveTableConfig(TableConfig tableConfig);
}
