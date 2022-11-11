package com.app.springmongo.controller;

import com.app.springmongo.entity.TableConfig;
import com.app.springmongo.entity.Test;
import com.app.springmongo.repository.TableConfigRepo;
import com.app.springmongo.service.TableConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TableConfigController {
    @Autowired
    private TableConfigRepo tableConfigRepo;

    @Autowired
    private TableConfigService tableConfigService;

    @GetMapping("/table-config")
    public ResponseEntity<List<TableConfig>> getAllTableConfig() {
        try {

            List<TableConfig> tableConfigs = new ArrayList<>(tableConfigService.getAllTableConfig());
            return new ResponseEntity<>(tableConfigs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/table-config/{tableId}")
    public ResponseEntity<TableConfig> getTableConfigById(@PathVariable("tableId") String tableId) {
        try {
            Optional<TableConfig> optional = tableConfigService.getTableConfigById(tableId);
            return optional.map(tableConfig -> new ResponseEntity<>(tableConfig, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/table-config")
    public ResponseEntity<TableConfig> saveTableConfig(@RequestBody TableConfig tableConfig) {
        Optional<TableConfig> tableConfigOptional = tableConfigService.getTableConfigById(tableConfig.getTableId());
        try {
            if (tableConfigOptional.isPresent()) {
                TableConfig _tableConfig = tableConfigOptional.get();
                _tableConfig.setTableConfig(tableConfig.getTableConfig());
                return new ResponseEntity<>(tableConfigService.saveTableConfig(_tableConfig), HttpStatus.OK);
            } else {
                TableConfig _tableConfig = tableConfigRepo.save(tableConfig);
                return new ResponseEntity<>(_tableConfig, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
