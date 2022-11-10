package com.app.springmongo.controller;

import com.app.springmongo.entity.TableConfig;
import com.app.springmongo.entity.Test;
import com.app.springmongo.repository.TableConfigRepo;
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

    @GetMapping("/table-config")
    public ResponseEntity<List<TableConfig>> getAllTutorials() {
        try {
            tableConfigRepo.findAll();
            return new ResponseEntity<>(tableConfigRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(tableConfigRepo.findAll(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/table-config/{id}")
    public ResponseEntity<List<TableConfig>> getTutorials(@PathVariable("id") String id) {
        Optional<TableConfig> tutorialData = Optional.ofNullable(tableConfigRepo.findByTableId(id));

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tableConfigRepo.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping("/table-config")
    public ResponseEntity<TableConfig> save(@RequestBody TableConfig tableConfig) {
        System.out.println(tableConfig.getTableId());
        Optional<TableConfig> tutorialData = Optional.ofNullable(tableConfigRepo.findByTableId(tableConfig.getTableId()));

        System.out.println(tutorialData);

        if (tutorialData.isPresent()) {
            TableConfig _tutorial = tutorialData.get();
            System.out.println(_tutorial);

            _tutorial.setTableConfig(tableConfig.getTableConfig());

            return new ResponseEntity<>(tableConfigRepo.save(_tutorial), HttpStatus.OK);
        } else {
            TableConfig _tableConfig = tableConfigRepo.save(tableConfig);
            return new ResponseEntity<>(_tableConfig, HttpStatus.CREATED);
//
        }
    }

    @PutMapping("/table-config/{id}")
    public ResponseEntity<TableConfig> updateTutorial(@PathVariable("id") String id, @RequestBody TableConfig tableConfig) {

        Optional<TableConfig> tutorialData = Optional.ofNullable(tableConfigRepo.findByTableId(id));

        if (tutorialData.isPresent()) {
            TableConfig _tutorial = tutorialData.get();
            _tutorial.setTableConfig(tableConfig.getTableConfig());
            return new ResponseEntity<>(tableConfigRepo.save(_tutorial), HttpStatus.OK);
        } else {
            TableConfig _tableConfig = tableConfigRepo.save(tableConfig);
            return new ResponseEntity<>(_tableConfig, HttpStatus.CREATED);
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
