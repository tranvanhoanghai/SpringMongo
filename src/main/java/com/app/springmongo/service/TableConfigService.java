package com.app.springmongo.service;

import com.app.springmongo.entity.TableConfig;
import java.util.List;
import java.util.Optional;

public interface TableConfigService {
    List<TableConfig> getAllTableConfig();

    Optional<TableConfig>  getTableConfigById(String tableId);

    TableConfig saveTableConfig(TableConfig tableConfig);
}
