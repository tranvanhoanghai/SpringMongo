package com.app.springmongo.controller;

import com.app.springmongo.entity.Test;
import com.app.springmongo.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestRepo testRepo;

    @GetMapping("/test")
    public ResponseEntity<List<Test>> getAllTutorials() {
        List<Test> test = new ArrayList<>();
//        test = testRepo.findAll();
        System.out.println(testRepo.findAll());
        return new ResponseEntity<>(testRepo.findAll(), HttpStatus.OK);
    }
}
